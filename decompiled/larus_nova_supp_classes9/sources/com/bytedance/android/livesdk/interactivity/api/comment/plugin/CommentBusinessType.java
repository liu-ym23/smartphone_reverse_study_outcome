package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentBusinessType;", BuildConfig.FLAVOR, "Normal", "Danmu", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentBusinessType extends Enum<CommentBusinessType> {
    public static final CommentBusinessType Danmu = null;
    public static final CommentBusinessType Normal = null;
    public static final /* synthetic */ CommentBusinessType[] a = null;

    static {
        CommentBusinessType r1 = new CommentBusinessType("Normal", 0);
        Normal = r1;
        CommentBusinessType r2 = new CommentBusinessType("Danmu", 1);
        Danmu = r2;
        a = new CommentBusinessType[]{r1, r2};
    }

    public static CommentBusinessType valueOf(String r1) {
        return (CommentBusinessType) a.a(CommentBusinessType.class, r1);
    }

    public static CommentBusinessType[] values() {
        return (CommentBusinessType[]) a.clone();
    }

    public CommentBusinessType(String r1, int r2) {
        super(r1, r2);
    }
}
