package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentContentType;", BuildConfig.FLAVOR, "Text", "Image", "RichText", "Audio", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentContentType extends Enum<CommentContentType> {
    public static final CommentContentType Audio = null;
    public static final CommentContentType Image = null;
    public static final CommentContentType RichText = null;
    public static final CommentContentType Text = null;
    public static final /* synthetic */ CommentContentType[] a = null;

    static {
        CommentContentType r1 = new CommentContentType("Text", 0);
        Text = r1;
        CommentContentType r2 = new CommentContentType("Image", 1);
        Image = r2;
        CommentContentType r3 = new CommentContentType("RichText", 2);
        RichText = r3;
        CommentContentType r4 = new CommentContentType("Audio", 3);
        Audio = r4;
        a = new CommentContentType[]{r1, r2, r3, r4};
    }

    public static CommentContentType valueOf(String r1) {
        return (CommentContentType) a.a(CommentContentType.class, r1);
    }

    public static CommentContentType[] values() {
        return (CommentContentType[]) a.clone();
    }

    public CommentContentType(String r1, int r2) {
        super(r1, r2);
    }
}
