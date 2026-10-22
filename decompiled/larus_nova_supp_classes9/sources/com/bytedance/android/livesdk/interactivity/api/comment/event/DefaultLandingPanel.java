package com.bytedance.android.livesdk.interactivity.api.comment.event;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/event/DefaultLandingPanel;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "panel", "Ljava/lang/String;", "getPanel", "()Ljava/lang/String;", "Default", "Emoji", "Video", "Audio", "Collection", "FastComment", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DefaultLandingPanel extends Enum<DefaultLandingPanel> {
    public static final DefaultLandingPanel Audio = null;
    public static final DefaultLandingPanel Collection = null;
    public static final DefaultLandingPanel Default = null;
    public static final DefaultLandingPanel Emoji = null;
    public static final DefaultLandingPanel FastComment = null;
    public static final DefaultLandingPanel Video = null;
    public static final /* synthetic */ DefaultLandingPanel[] a = null;
    private final String panel;

    static {
        DefaultLandingPanel r1 = new DefaultLandingPanel("Default", 0, "default");
        Default = r1;
        DefaultLandingPanel r2 = new DefaultLandingPanel("Emoji", 1, "emoji");
        Emoji = r2;
        DefaultLandingPanel r3 = new DefaultLandingPanel("Video", 2, "video");
        Video = r3;
        DefaultLandingPanel r4 = new DefaultLandingPanel("Audio", 3, "audio");
        Audio = r4;
        DefaultLandingPanel r5 = new DefaultLandingPanel("Collection", 4, "collection");
        Collection = r5;
        DefaultLandingPanel r6 = new DefaultLandingPanel("FastComment", 5, "common_comment");
        FastComment = r6;
        a = new DefaultLandingPanel[]{r1, r2, r3, r4, r5, r6};
    }

    public static DefaultLandingPanel valueOf(String r1) {
        return (DefaultLandingPanel) a.a(DefaultLandingPanel.class, r1);
    }

    public static DefaultLandingPanel[] values() {
        return (DefaultLandingPanel[]) a.clone();
    }

    public final String getPanel() {
        return this.panel;
    }

    public DefaultLandingPanel(String r1, int r2, String r3) {
        super(r1, r2);
        this.panel = r3;
    }
}
