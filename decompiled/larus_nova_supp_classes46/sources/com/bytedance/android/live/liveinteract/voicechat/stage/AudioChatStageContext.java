package com.bytedance.android.live.liveinteract.voicechat.stage;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/stage/AudioChatStageContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lmj0/a;", "Lcom/bytedance/live/datacontext/j;", "", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "", "isStageShowing$delegate", "isStageShowing", "()Lcom/bytedance/live/datacontext/m;", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioChatStageContext extends DataContext implements mj0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "AudioChatStageContext";
    private final p isStageShowing$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final AudioChatStageContext getContext() {
            DataContext r0 = d.d(mj0.a.class);
            if ((r0 instanceof AudioChatStageContext) == true) goto L6;
            r0 = null;
        L6:
            return (AudioChatStageContext) r0;
        }

        public final Observable<Boolean> a() {
            AudioChatStageContext r0 = getContext();
            if (r0 == null) goto L7;
            m<Boolean> r1 = r0.isStageShowing();
            if (r1 == null) goto L7;
            return r1.a();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AudioChatStageContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AudioChatStageContext.class, "isStageShowing", "isStageShowing()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final j<Object> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> isStageShowing() {
        return (m) this.isStageShowing$delegate.a(this, $$delegatedProperties[1]);
    }

    public AudioChatStageContext() {
        this.service$delegate = ConstantKt.c(this);
        this.isStageShowing$delegate = q.d(this, Boolean.FALSE);
    }
}
