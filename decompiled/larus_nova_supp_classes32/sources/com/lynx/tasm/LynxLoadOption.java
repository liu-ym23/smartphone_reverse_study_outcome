package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxLoadOption extends Enum<LynxLoadOption> {
    public static final LynxLoadOption DUMP_ELEMENT = null;
    public static final LynxLoadOption PROCESS_LAYOUT_WITHOUT_UI_FLUSH = null;
    public static final LynxLoadOption RECYCLE_TEMPLATE_BUNDLE = null;
    public static final LynxLoadOption RENDER_FOR_RECREATE_ENGINE = null;
    public static final /* synthetic */ LynxLoadOption[] a = null;
    private int mId;

    static {
        LynxLoadOption r0 = new LynxLoadOption("DUMP_ELEMENT", 0, 2);
        DUMP_ELEMENT = r0;
        LynxLoadOption r1 = new LynxLoadOption("RECYCLE_TEMPLATE_BUNDLE", 1, 4);
        RECYCLE_TEMPLATE_BUNDLE = r1;
        LynxLoadOption r4 = new LynxLoadOption("PROCESS_LAYOUT_WITHOUT_UI_FLUSH", 2, 8);
        PROCESS_LAYOUT_WITHOUT_UI_FLUSH = r4;
        LynxLoadOption r7 = new LynxLoadOption("RENDER_FOR_RECREATE_ENGINE", 3, 16);
        RENDER_FOR_RECREATE_ENGINE = r7;
        a = new LynxLoadOption[]{r0, r1, r4, r7};
    }

    public static LynxLoadOption[] values() {
        return (LynxLoadOption[]) a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static LynxLoadOption valueOf(String r1) {
        return (LynxLoadOption) r27.a.a(LynxLoadOption.class, r1);
    }

    public LynxLoadOption(String r1, int r2, int r3) {
        super(r1, r2);
        this.mId = r3;
    }
}
