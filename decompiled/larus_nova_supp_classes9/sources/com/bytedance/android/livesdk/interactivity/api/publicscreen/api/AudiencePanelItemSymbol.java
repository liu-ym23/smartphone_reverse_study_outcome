package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011j\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/AudiencePanelItemSymbol;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "id", "J", "getId", "()J", "priority", "getPriority", "setPriority", "(J)V", BuildConfig.FLAVOR, "showOutside", "Z", "getShowOutside", "()Z", "setShowOutside", "(Z)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "outsideName", "Ljava/util/List;", "getOutsideName", "()Ljava/util/List;", "setOutsideName", "(Ljava/util/List;)V", "insideName", "getInsideName", "setInsideName", "canShow", "getCanShow", "setCanShow", "PROFILE", "LIKE", "DISLIKE", "AT", "COPY", "MORE", "REPORT", "SECRET_CHAT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudiencePanelItemSymbol extends Enum<AudiencePanelItemSymbol> {
    public static final AudiencePanelItemSymbol AT = null;
    public static final AudiencePanelItemSymbol COPY = null;
    public static final AudiencePanelItemSymbol DISLIKE = null;
    public static final AudiencePanelItemSymbol LIKE = null;
    public static final AudiencePanelItemSymbol MORE = null;
    public static final AudiencePanelItemSymbol PROFILE = null;
    public static final AudiencePanelItemSymbol REPORT = null;
    public static final AudiencePanelItemSymbol SECRET_CHAT = null;
    public static final /* synthetic */ AudiencePanelItemSymbol[] a = null;
    private boolean canShow;
    private final long id;
    private List<String> insideName;
    private List<String> outsideName;
    private long priority;
    private boolean showOutside;

    public static AudiencePanelItemSymbol valueOf(String r1) {
        return (AudiencePanelItemSymbol) r27.a.a(AudiencePanelItemSymbol.class, r1);
    }

    public static AudiencePanelItemSymbol[] values() {
        return (AudiencePanelItemSymbol[]) a.clone();
    }

    static {
        AudiencePanelItemSymbol r11 = new AudiencePanelItemSymbol("PROFILE", 0, 1, 1000, true, CollectionsKt.mutableListOf(new String[]{"资料卡"}), CollectionsKt.mutableListOf(new String[]{"资料卡"}));
        PROFILE = r11;
        AudiencePanelItemSymbol r1 = new AudiencePanelItemSymbol("LIKE", 1, 2, 900, true, CollectionsKt.mutableListOf(new String[]{"点赞"}), CollectionsKt.mutableListOf(new String[]{"点赞"}));
        LIKE = r1;
        AudiencePanelItemSymbol r2 = new AudiencePanelItemSymbol("DISLIKE", 2, 3, 800, true, CollectionsKt.mutableListOf(new String[]{"不喜欢"}), CollectionsKt.mutableListOf(new String[]{"不喜欢"}));
        DISLIKE = r2;
        AudiencePanelItemSymbol r3 = new AudiencePanelItemSymbol("AT", 3, 4, 700, true, CollectionsKt.mutableListOf(new String[]{"@TA", "回复"}), CollectionsKt.mutableListOf(new String[]{"@TA", "回复"}));
        AT = r3;
        AudiencePanelItemSymbol r4 = new AudiencePanelItemSymbol("COPY", 4, 5, 600, false, CollectionsKt.mutableListOf(new String[]{"复制"}), CollectionsKt.mutableListOf(new String[]{"复制该评论"}));
        COPY = r4;
        AudiencePanelItemSymbol r5 = new AudiencePanelItemSymbol("MORE", 5, 99, 500, true, CollectionsKt.mutableListOf(new String[]{"更多"}), CollectionsKt.mutableListOf(new String[]{"更多"}));
        MORE = r5;
        AudiencePanelItemSymbol r6 = new AudiencePanelItemSymbol("REPORT", 6, 6, 400, false, CollectionsKt.mutableListOf(new String[]{"举报"}), CollectionsKt.mutableListOf(new String[]{"举报"}));
        REPORT = r6;
        AudiencePanelItemSymbol r7 = new AudiencePanelItemSymbol("SECRET_CHAT", 7, 7, 750, true, CollectionsKt.mutableListOf(new String[]{"对TA说", "回复"}), CollectionsKt.mutableListOf(new String[]{"对TA说", "回复"}));
        SECRET_CHAT = r7;
        a = new AudiencePanelItemSymbol[]{r11, r1, r2, r3, r4, r5, r6, r7};
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final long getId() {
        return this.id;
    }

    public final List<String> getInsideName() {
        return this.insideName;
    }

    public final List<String> getOutsideName() {
        return this.outsideName;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final boolean getShowOutside() {
        return this.showOutside;
    }

    public final void setCanShow(boolean r1) {
        this.canShow = r1;
    }

    public final void setInsideName(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.insideName = r2;
    }

    public final void setOutsideName(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.outsideName = r2;
    }

    public final void setPriority(long r1) {
        this.priority = r1;
    }

    public final void setShowOutside(boolean r1) {
        this.showOutside = r1;
    }

    public AudiencePanelItemSymbol(String r1, int r2, long r3, long r5, boolean r7, List r8, List r9) {
        super(r1, r2);
        this.id = r3;
        this.priority = r5;
        this.showOutside = r7;
        this.outsideName = r8;
        this.insideName = r9;
        this.canShow = true;
    }
}
