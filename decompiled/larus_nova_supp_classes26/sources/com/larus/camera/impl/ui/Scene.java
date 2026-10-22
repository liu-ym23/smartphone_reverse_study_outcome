package com.larus.camera.impl.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/impl/ui/Scene;", "", "<init>", "(Ljava/lang/String;I)V", "CAPTURE", "RESULT", "EDIT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scene extends Enum<Scene> {
    public static final Scene CAPTURE = null;
    public static final Scene EDIT = null;
    public static final Scene RESULT = null;
    public static final /* synthetic */ Scene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Scene> getEntries() {
        return b;
    }

    static {
        Scene r0 = new Scene("CAPTURE", 0);
        CAPTURE = r0;
        Scene r1 = new Scene("RESULT", 1);
        RESULT = r1;
        Scene r3 = new Scene("EDIT", 2);
        EDIT = r3;
        Scene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static Scene[] values() {
        return (Scene[]) a.clone();
    }

    public static Scene valueOf(String r1) {
        return (Scene) a.a(Scene.class, r1);
    }

    public Scene(String r1, int r2) {
        super(r1, r2);
    }
}
