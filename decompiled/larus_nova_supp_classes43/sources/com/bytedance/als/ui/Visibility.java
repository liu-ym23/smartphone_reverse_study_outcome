package com.bytedance.als.ui;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/als/ui/Visibility;", "", "SHOW", "HIDE", "als_release"}, k = 1, mv = {1, 4, 1})
public final enum Visibility extends Enum<Visibility> {
    public static final Visibility HIDE = null;
    public static final Visibility SHOW = null;
    public static final /* synthetic */ Visibility[] a = null;

    static {
        Visibility r1 = new Visibility("SHOW", 0);
        SHOW = r1;
        Visibility r10 = new Visibility("HIDE", 1);
        HIDE = r10;
        a = new Visibility[]{r1, r10};
    }

    public static Visibility valueOf(String r1) {
        return (Visibility) a.a(Visibility.class, r1);
    }

    public static Visibility[] values() {
        return (Visibility[]) a.clone();
    }

    public Visibility(String r1, int r10) {
        super(r1, r10);
    }
}
