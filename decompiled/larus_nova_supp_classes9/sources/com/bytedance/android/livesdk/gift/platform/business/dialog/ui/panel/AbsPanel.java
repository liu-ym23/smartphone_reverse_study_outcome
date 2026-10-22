package com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel;

import com.bytedance.android.livesdk.gift.model.e3;
import java.util.ArrayList;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class AbsPanel<T> {
    public final int a;
    public ArrayList<e3> b;
    public String c;
    public GiftPanelSelectType d;
    public boolean e;
    public GiftPanelIconSource f;
    public long g;
    public final T h;

    public static final enum GiftPanelIconSource extends Enum<GiftPanelIconSource> {
        public static final GiftPanelIconSource DIY_CARD = null;
        public static final GiftPanelIconSource GIFT_LIST = null;
        public static final /* synthetic */ GiftPanelIconSource[] a = null;

        static {
            GiftPanelIconSource r0 = new GiftPanelIconSource("GIFT_LIST", 0);
            GIFT_LIST = r0;
            GiftPanelIconSource r1 = new GiftPanelIconSource("DIY_CARD", 1);
            DIY_CARD = r1;
            a = new GiftPanelIconSource[]{r0, r1};
        }

        public static GiftPanelIconSource[] values() {
            return (GiftPanelIconSource[]) a.clone();
        }

        public static GiftPanelIconSource valueOf(String r1) {
            return (GiftPanelIconSource) r27.a.a(GiftPanelIconSource.class, r1);
        }

        public GiftPanelIconSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum GiftPanelSelectType extends Enum<GiftPanelSelectType> {
        public static final GiftPanelSelectType DEFAULT_SELECTED = null;
        public static final GiftPanelSelectType IDLE = null;
        public static final GiftPanelSelectType JUST_SELECTED = null;
        public static final GiftPanelSelectType LOCATED = null;
        public static final GiftPanelSelectType NORMAL_SELECTED = null;
        public static final /* synthetic */ GiftPanelSelectType[] a = null;

        static {
            GiftPanelSelectType r0 = new GiftPanelSelectType("IDLE", 0);
            IDLE = r0;
            GiftPanelSelectType r1 = new GiftPanelSelectType("NORMAL_SELECTED", 1);
            NORMAL_SELECTED = r1;
            GiftPanelSelectType r3 = new GiftPanelSelectType("LOCATED", 2);
            LOCATED = r3;
            GiftPanelSelectType r5 = new GiftPanelSelectType("DEFAULT_SELECTED", 3);
            DEFAULT_SELECTED = r5;
            GiftPanelSelectType r7 = new GiftPanelSelectType("JUST_SELECTED", 4);
            JUST_SELECTED = r7;
            a = new GiftPanelSelectType[]{r0, r1, r3, r5, r7};
        }

        public static GiftPanelSelectType[] values() {
            return (GiftPanelSelectType[]) a.clone();
        }

        public static GiftPanelSelectType valueOf(String r1) {
            return (GiftPanelSelectType) r27.a.a(GiftPanelSelectType.class, r1);
        }

        public GiftPanelSelectType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract String a();

    public k b() {
        return null;
    }

    public abstract long c();

    public abstract k d();

    public k e() {
        return null;
    }

    public abstract String f();

    public k g() {
        return null;
    }

    public boolean i() {
        return false;
    }

    public final boolean h() {
        if (this.d == GiftPanelSelectType.IDLE) goto L5;
        return true;
    L5:
        return false;
    }

    public AbsPanel(int r3, T r4) {
        this.b = null;
        this.c = null;
        this.d = GiftPanelSelectType.IDLE;
        this.e = false;
        this.f = GiftPanelIconSource.GIFT_LIST;
        this.g = 0;
        this.a = r3;
        this.h = r4;
    }
}
