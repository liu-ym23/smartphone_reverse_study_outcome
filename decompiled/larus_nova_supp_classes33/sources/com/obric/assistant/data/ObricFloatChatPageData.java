package com.obric.assistant.data;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vda.d;
import vda.e;
import vda.f;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/data/ObricFloatChatPageData;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "<init>", "(Lcom/obric/assistant/data/ObricFloatChatPageState;)V", "getPageState", "()Lcom/obric/assistant/data/ObricFloatChatPageState;", "component1", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFloatChatPageData implements b {
    private static final String CHAT_WINDOW_SIMPLE_NAME = null;
    public static final a Companion = null;
    private static final String FULL_SCREEN_SIMPLE_NAME = null;
    private static final String HALF_WINDOW_SIMPLE_NAME = null;
    private static final String LANDSCAPE_FULL_WINDOW_SIMPLE_NAME = null;
    private static final com.obric.assistant.data.a UNKNOWN = null;
    private final ObricFloatChatPageState pageState;

    public static final class a {
        public a() {
        }

        public static boolean a(ObricFloatChatPageState r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            if ((r1 instanceof vda.a) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r1 instanceof e) == true) goto L8;
            return false;
        }

        public static boolean b(ObricFloatChatPageState r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            if ((r1 instanceof vda.b) == true) goto L5;
        L7:
            return false;
        L5:
            if (((vda.b) r1).c == false) goto L7;
            return true;
        }

        public static boolean c(ObricFloatChatPageState r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return r1 instanceof com.obric.assistant.data.a;
        }

        public static boolean d(ObricFloatChatPageState r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            if (a(r1) == false) goto L5;
        L10:
            return true;
        L5:
            if ((r1 instanceof d) == true) goto L10;
            if ((r1 instanceof f) == true) goto L10;
            return false;
        }

        public static boolean e(ObricFloatChatPageState r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            if ((r1 instanceof vda.b) == true) goto L5;
        L7:
            return false;
        L5:
            if (((vda.b) r1).b == false) goto L7;
            return true;
        }
    }

    public ObricFloatChatPageData() {
        ObricFloatChatPageState r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ ObricFloatChatPageData copy$default(ObricFloatChatPageData r0, ObricFloatChatPageState r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.pageState;
    L6:
        return r0.copy(r1);
    }

    public final ObricFloatChatPageState component1() {
        return this.pageState;
    }

    public final ObricFloatChatPageData copy(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
        return new ObricFloatChatPageData(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ObricFloatChatPageData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.pageState, ((ObricFloatChatPageData) r4).pageState) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.pageState.hashCode();
    }

    public String toString() {
        return "ObricFloatChatPageData(pageState=" + this.pageState + ')';
    }

    static {
        Companion = new a();
        UNKNOWN = com.obric.assistant.data.a.a;
        CHAT_WINDOW_SIMPLE_NAME = vda.a.class.getSimpleName();
        HALF_WINDOW_SIMPLE_NAME = e.class.getSimpleName();
        FULL_SCREEN_SIMPLE_NAME = d.class.getSimpleName();
        LANDSCAPE_FULL_WINDOW_SIMPLE_NAME = f.class.getSimpleName();
    }

    public static final /* synthetic */ String access$getCHAT_WINDOW_SIMPLE_NAME$cp() {
        return CHAT_WINDOW_SIMPLE_NAME;
    }

    public static final /* synthetic */ String access$getFULL_SCREEN_SIMPLE_NAME$cp() {
        return FULL_SCREEN_SIMPLE_NAME;
    }

    public static final /* synthetic */ String access$getHALF_WINDOW_SIMPLE_NAME$cp() {
        return HALF_WINDOW_SIMPLE_NAME;
    }

    public static final /* synthetic */ String access$getLANDSCAPE_FULL_WINDOW_SIMPLE_NAME$cp() {
        return LANDSCAPE_FULL_WINDOW_SIMPLE_NAME;
    }

    public static final /* synthetic */ com.obric.assistant.data.a access$getUNKNOWN$cp() {
        return UNKNOWN;
    }

    public final ObricFloatChatPageState getPageState() {
        return this.pageState;
    }

    public ObricFloatChatPageData(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
        this.pageState = r2;
    }

    public /* synthetic */ ObricFloatChatPageData(ObricFloatChatPageState r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = UNKNOWN;
    L5:
        this(r1);
    }
}
