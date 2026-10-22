package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentScene;", BuildConfig.FLAVOR, "PublicScreen", "ChatChannel", "SecretChat", "SquareChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentScene extends Enum<CommentScene> {
    public static final CommentScene ChatChannel = null;
    public static final CommentScene PublicScreen = null;
    public static final CommentScene SecretChat = null;
    public static final CommentScene SquareChat = null;
    public static final /* synthetic */ CommentScene[] a = null;

    static {
        CommentScene r1 = new CommentScene("PublicScreen", 0);
        PublicScreen = r1;
        CommentScene r2 = new CommentScene("ChatChannel", 1);
        ChatChannel = r2;
        CommentScene r3 = new CommentScene("SecretChat", 2);
        SecretChat = r3;
        CommentScene r4 = new CommentScene("SquareChat", 3);
        SquareChat = r4;
        a = new CommentScene[]{r1, r2, r3, r4};
    }

    public static CommentScene valueOf(String r1) {
        return (CommentScene) a.a(CommentScene.class, r1);
    }

    public static CommentScene[] values() {
        return (CommentScene[]) a.clone();
    }

    public CommentScene(String r1, int r2) {
        super(r1, r2);
    }
}
