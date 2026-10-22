package com.google.devtools.ksp.symbol;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/google/devtools/ksp/symbol/Variance;", "", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "STAR", "INVARIANT", "COVARIANT", "CONTRAVARIANT", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Variance extends Enum<Variance> {
    public static final Variance CONTRAVARIANT = null;
    public static final Variance COVARIANT = null;
    public static final Variance INVARIANT = null;
    public static final Variance STAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Variance[] f9456a = null;
    private final String label;

    static {
        Variance r5 = new Variance("STAR", 0, XPath.WILDCARD);
        STAR = r5;
        Variance r10 = new Variance("INVARIANT", 1, "");
        INVARIANT = r10;
        Variance r11 = new Variance("COVARIANT", 2, "out");
        COVARIANT = r11;
        Variance r12 = new Variance("CONTRAVARIANT", 3, "in");
        CONTRAVARIANT = r12;
        f9456a = new Variance[]{r5, r10, r11, r12};
    }

    public Variance(String r5, int r10, String r11) {
        super(r5, r10);
        this.label = r11;
    }

    public static Variance valueOf(String r5) {
        return (Variance) Enum.valueOf(Variance.class, r5);
    }

    public static Variance[] values() {
        return (Variance[]) f9456a.clone();
    }

    public final String getLabel() {
        return this.label;
    }
}
