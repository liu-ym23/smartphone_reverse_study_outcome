package com.ss.android.lark.chat.chatwindow.biz.plugin.watermark;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/plugin/watermark/ChatWatermarkViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "watermarkState", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "updateWatermarkState", BuildConfig.FLAVOR, "state", "getWatermarkState", "WatermarkAttachState", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWatermarkViewModel extends ViewModel {
    private final MutableLiveData<Integer> watermarkState;

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/plugin/watermark/ChatWatermarkViewModel$WatermarkAttachState;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface WatermarkAttachState {
        public static final int ATTACHED = 3;
        public static final int CLEARED = 2;
        public static final a Companion = null;
        public static final int NOT_ATTACHED = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public final int getWatermarkState() {
        Integer r0 = (Integer) this.watermarkState.getValue();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.intValue();
    }

    public ChatWatermarkViewModel() {
        this.watermarkState = new MutableLiveData(1);
    }

    public final void updateWatermarkState(int r2) {
        this.watermarkState.setValue(Integer.valueOf(r2));
    }
}
