package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum Domain extends Enum<Domain> {
    public static final /* synthetic */ Domain[] a = null;
    public static final Domain calendar = null;
    public static final Domain chat = null;
    public static final Domain docs = null;
    public static final Domain event = null;
    public static final Domain message = null;
    public static final Domain sheet = null;
    public static final Domain todo = null;
    private int value;

    static {
        Domain r0 = new Domain("chat", 0, 1);
        chat = r0;
        Domain r1 = new Domain("message", 1, 2);
        message = r1;
        Domain r4 = new Domain("event", 2, 3);
        event = r4;
        Domain r6 = new Domain("calendar", 3, 4);
        calendar = r6;
        Domain r8 = new Domain("docs", 4, 5);
        docs = r8;
        Domain r10 = new Domain("sheet", 5, 6);
        sheet = r10;
        Domain r12 = new Domain("todo", 6, 7);
        todo = r12;
        a = new Domain[]{r0, r1, r4, r6, r8, r10, r12};
    }

    public static Domain[] values() {
        return (Domain[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static Domain forNumber(int r0) {
        switch(r0) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return todo;
    L8:
        return sheet;
    L10:
        return docs;
    L12:
        return calendar;
    L14:
        return event;
    L16:
        return message;
    L18:
        return chat;
    }

    public static Domain valueOf(String r1) {
        return (Domain) r27.a.a(Domain.class, r1);
    }

    public static Domain valueOf(int r0) {
        return forNumber(r0);
    }

    public Domain(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
