package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/util/ContainerType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Full", "Left", "Right", "Top", "Bottom", "Web", "Title", "NestScrollTitle", "Root", "Content", "BusinessOverlay", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType Bottom = null;
    public static final ContainerType BusinessOverlay = null;
    public static final ContainerType Content = null;
    public static final ContainerType Full = null;
    public static final ContainerType Left = null;
    public static final ContainerType NestScrollTitle = null;
    public static final ContainerType Right = null;
    public static final ContainerType Root = null;
    public static final ContainerType Title = null;
    public static final ContainerType Top = null;
    public static final ContainerType Web = null;
    public static final /* synthetic */ ContainerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ContainerType> getEntries() {
        return b;
    }

    static {
        ContainerType r0 = new ContainerType("Full", 0, 0);
        Full = r0;
        ContainerType r1 = new ContainerType("Left", 1, 1);
        Left = r1;
        ContainerType r3 = new ContainerType("Right", 2, 2);
        Right = r3;
        ContainerType r5 = new ContainerType("Top", 3, 3);
        Top = r5;
        ContainerType r7 = new ContainerType("Bottom", 4, 4);
        Bottom = r7;
        ContainerType r9 = new ContainerType("Web", 5, 5);
        Web = r9;
        ContainerType r11 = new ContainerType("Title", 6, 6);
        Title = r11;
        ContainerType r13 = new ContainerType("NestScrollTitle", 7, 7);
        NestScrollTitle = r13;
        ContainerType r15 = new ContainerType("Root", 8, 8);
        Root = r15;
        ContainerType r14 = new ContainerType("Content", 9, 9);
        Content = r14;
        ContainerType r12 = new ContainerType("BusinessOverlay", 10, 10);
        BusinessOverlay = r12;
        ContainerType[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContainerType valueOf(String r1) {
        return (ContainerType) r27.a.a(ContainerType.class, r1);
    }

    public ContainerType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
