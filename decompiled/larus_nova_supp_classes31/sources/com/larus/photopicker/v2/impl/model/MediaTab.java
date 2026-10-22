package com.larus.photopicker.v2.impl.model;

import com.larus.common.apphost.AppHost;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0013"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaTab;", "", "title", "", "mobName", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getMobName", "getId", "()I", "ALL", "VIDEO", "IMAGE", "toMediaType", "Lcom/larus/photopicker/v2/impl/data/model/MediaType;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum MediaTab extends Enum<MediaTab> {
    public static final MediaTab ALL = null;
    public static final MediaTab IMAGE = null;
    public static final MediaTab VIDEO = null;
    public static final /* synthetic */ MediaTab[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int id;
    private final String mobName;
    private final String title;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaTab.values().length];
            r0[MediaTab.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MediaTab.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MediaTab.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static EnumEntries<MediaTab> getEntries() {
        return b;
    }

    static {
        AppHost.Companion r7 = AppHost.a;
        MediaTab r6 = new MediaTab("ALL", 0, r7.getApplication().getResources().getString(2131910961), "all", 0);
        ALL = r6;
        MediaTab r0 = new MediaTab("VIDEO", 1, r7.getApplication().getResources().getString(2131910963), "video", 1);
        VIDEO = r0;
        MediaTab r1 = new MediaTab("IMAGE", 2, r7.getApplication().getResources().getString(2131910962), "pic", 2);
        IMAGE = r1;
        MediaTab[] r2 = {r6, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static MediaTab[] values() {
        return (MediaTab[]) a.clone();
    }

    public final MediaType toMediaType() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        return null;
    L5:
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L10;
        return MediaType.IMAGE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return MediaType.VIDEO;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMobName() {
        return this.mobName;
    }

    public final String getTitle() {
        return this.title;
    }

    public static MediaTab valueOf(String r1) {
        return (MediaTab) r27.a.a(MediaTab.class, r1);
    }

    public MediaTab(String r1, int r2, String r3, String r4, int r5) {
        super(r1, r2);
        this.title = r3;
        this.mobName = r4;
        this.id = r5;
    }
}
