package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmAppletPage;", "", AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "INDEX", "HOME", "RECORDING", "END_WINDOW", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAppletPage extends Enum<MmAppletPage> {
    public static final a Companion = null;
    public static final MmAppletPage END_WINDOW = null;
    public static final MmAppletPage HOME = null;
    public static final MmAppletPage INDEX = null;
    public static final MmAppletPage RECORDING = null;
    public static final /* synthetic */ MmAppletPage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String path;

    public static final class a {
        public a() {
        }

        public static String a(MmAppletPage r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "page");
            Intrinsics.checkNotNullParameter(r2, "id");
            return r1.getPath() + '_' + r2;
        }
    }

    public static EnumEntries<MmAppletPage> getEntries() {
        return b;
    }

    static {
        MmAppletPage r0 = new MmAppletPage("INDEX", 0, "index");
        INDEX = r0;
        MmAppletPage r1 = new MmAppletPage("HOME", 1, "home");
        HOME = r1;
        MmAppletPage r3 = new MmAppletPage("RECORDING", 2, "recording");
        RECORDING = r3;
        MmAppletPage r5 = new MmAppletPage("END_WINDOW", 3, "endwindow");
        END_WINDOW = r5;
        MmAppletPage[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static MmAppletPage[] values() {
        return (MmAppletPage[]) a.clone();
    }

    public final String getPath() {
        return this.path;
    }

    public static MmAppletPage valueOf(String r1) {
        return (MmAppletPage) r27.a.a(MmAppletPage.class, r1);
    }

    public MmAppletPage(String r1, int r2, String r3) {
        super(r1, r2);
        this.path = r3;
    }
}
