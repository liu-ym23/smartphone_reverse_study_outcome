package com.bytedance.android.livesdk.interactivity.api.comment.data;

import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentScene;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/InputDraftType;", BuildConfig.FLAVOR, "Companion", "a", "Default", "Channel", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputDraftType extends Enum<InputDraftType> {
    public static final InputDraftType Channel = null;
    public static final a Companion = null;
    public static final InputDraftType Default = null;
    public static final /* synthetic */ InputDraftType[] a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final InputDraftType getType(CommentFlowContext r2) {
            if (r2 != null) goto L4;
        L6:
            boolean r3 = false;
        L7:
            if (r3 == false) goto L10;
            return InputDraftType.Channel;
        L10:
            return InputDraftType.Default;
        L4:
            if (r2.c != CommentScene.ChatChannel) goto L6;
            r3 = true;
            goto L7
        }
    }

    static {
        InputDraftType r1 = new InputDraftType("Default", 0);
        Default = r1;
        InputDraftType r2 = new InputDraftType("Channel", 1);
        Channel = r2;
        a = new InputDraftType[]{r1, r2};
        Companion = new a();
    }

    @JvmStatic
    public static final InputDraftType getType(CommentFlowContext r1) {
        return Companion.getType(r1);
    }

    public static InputDraftType valueOf(String r1) {
        return (InputDraftType) r27.a.a(InputDraftType.class, r1);
    }

    public static InputDraftType[] values() {
        return (InputDraftType[]) a.clone();
    }

    @JvmStatic
    public static final long getSceneId(CommentFlowContext r2) {
        Companion.getClass();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.l;
    }

    public InputDraftType(String r1, int r2) {
        super(r1, r2);
    }
}
