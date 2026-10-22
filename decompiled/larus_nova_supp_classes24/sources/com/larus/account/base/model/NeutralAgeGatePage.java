package com.larus.account.base.model;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/account/base/model/NeutralAgeGatePage;", "", "page", "", "mobPage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getPage", "()I", "getMobPage", "()Ljava/lang/String;", "DEFAULT", "FIRST_PAGE", "SECOND_PAGE", "THIRD_PAGE", "FOURTH_PAGE", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum NeutralAgeGatePage extends Enum<NeutralAgeGatePage> {
    public static final a Companion = null;
    public static final NeutralAgeGatePage DEFAULT = null;
    public static final NeutralAgeGatePage FIRST_PAGE = null;
    public static final NeutralAgeGatePage FOURTH_PAGE = null;
    public static final NeutralAgeGatePage SECOND_PAGE = null;
    public static final NeutralAgeGatePage THIRD_PAGE = null;
    public static final /* synthetic */ NeutralAgeGatePage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String mobPage;
    private final int page;

    public static EnumEntries<NeutralAgeGatePage> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.account.base.model.NeutralAgeGatePage$a] */
    static {
        NeutralAgeGatePage r0 = new NeutralAgeGatePage("DEFAULT", 0, 0, "default");
        DEFAULT = r0;
        NeutralAgeGatePage r1 = new NeutralAgeGatePage("FIRST_PAGE", 1, 1, "primary_page");
        FIRST_PAGE = r1;
        NeutralAgeGatePage r3 = new NeutralAgeGatePage("SECOND_PAGE", 2, 2, "secondary_page");
        SECOND_PAGE = r3;
        NeutralAgeGatePage r5 = new NeutralAgeGatePage("THIRD_PAGE", 3, 3, "tertiary_page");
        THIRD_PAGE = r5;
        NeutralAgeGatePage r7 = new NeutralAgeGatePage("FOURTH_PAGE", 4, 4, "quaternary_page");
        FOURTH_PAGE = r7;
        NeutralAgeGatePage[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static NeutralAgeGatePage[] values() {
        return (NeutralAgeGatePage[]) a.clone();
    }

    public final String getMobPage() {
        return this.mobPage;
    }

    public final int getPage() {
        return this.page;
    }

    public static NeutralAgeGatePage valueOf(String r1) {
        return (NeutralAgeGatePage) r27.a.a(NeutralAgeGatePage.class, r1);
    }

    public NeutralAgeGatePage(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.page = r3;
        this.mobPage = r4;
    }
}
