package com.larus.canvas.feature.host;

import android.os.Bundle;
import com.larus.canvas.feature.component.resultdisplay.image.CanvasSaveActionPlacement;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import my8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CanvasHostUiPolicy {
    public static final /* synthetic */ int c = 0;
    public final boolean a;
    public final boolean b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/host/CanvasHostUiPolicy$ExitBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "HOST_BACK", "HOST_CLOSE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExitBehavior extends Enum<ExitBehavior> {
        public static final ExitBehavior HOST_BACK = null;
        public static final ExitBehavior HOST_CLOSE = null;
        public static final ExitBehavior NATIVE = null;
        public static final /* synthetic */ ExitBehavior[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ExitBehavior> getEntries() {
            return b;
        }

        static {
            ExitBehavior r0 = new ExitBehavior("NATIVE", 0);
            NATIVE = r0;
            ExitBehavior r1 = new ExitBehavior("HOST_BACK", 1);
            HOST_BACK = r1;
            ExitBehavior r3 = new ExitBehavior("HOST_CLOSE", 2);
            HOST_CLOSE = r3;
            ExitBehavior[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ExitBehavior[] values() {
            return (ExitBehavior[]) a.clone();
        }

        public static ExitBehavior valueOf(String r1) {
            return (ExitBehavior) r27.a.a(ExitBehavior.class, r1);
        }

        public ExitBehavior(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/canvas/feature/host/CanvasHostUiPolicy$TitleLeftAction;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "BACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TitleLeftAction extends Enum<TitleLeftAction> {
        public static final TitleLeftAction BACK = null;
        public static final TitleLeftAction CLOSE = null;
        public static final /* synthetic */ TitleLeftAction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TitleLeftAction> getEntries() {
            return b;
        }

        static {
            TitleLeftAction r0 = new TitleLeftAction("CLOSE", 0);
            CLOSE = r0;
            TitleLeftAction r1 = new TitleLeftAction("BACK", 1);
            BACK = r1;
            TitleLeftAction[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static TitleLeftAction[] values() {
            return (TitleLeftAction[]) a.clone();
        }

        public static TitleLeftAction valueOf(String r1) {
            return (TitleLeftAction) r27.a.a(TitleLeftAction.class, r1);
        }

        public TitleLeftAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static CanvasHostUiPolicy a(q r2) {
            if (r2 == null) goto L4;
            Bundle r3 = r2.a;
        L5:
            cy9.a.a.getClass();
            return new CanvasHostUiPolicy(cy9.a.e(r3), !cy9.a.h(r3));
        L4:
            r3 = null;
            goto L5
        }
    }

    static {
    }

    public final boolean a() {
        if (this.a == false) goto L5;
        CanvasSaveActionPlacement r0 = CanvasSaveActionPlacement.IMAGE_OVERLAY_BOTTOM_START;
    L7:
        if (r0 != CanvasSaveActionPlacement.IMAGE_OVERLAY_BOTTOM_START) goto L9;
        return true;
    L9:
        return false;
    L5:
        r0 = CanvasSaveActionPlacement.TITLE_RIGHT;
        goto L7
    }

    public CanvasHostUiPolicy(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
