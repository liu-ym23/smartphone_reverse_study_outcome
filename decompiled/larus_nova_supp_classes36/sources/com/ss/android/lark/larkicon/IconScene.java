package com.ss.android.lark.larkicon;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/larkicon/IconScene;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOW", "TODO", "SYNC_BLOCK", "LYNX", "DOCUMENT", "VC", "MINUTES", "WIKI", "MQC", "HOME_PAGE", "QUICK_LAUNCH", "BITABLE", "TEMPLATE", "lark-icon_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum IconScene extends Enum<IconScene> {
    public static final IconScene BITABLE = null;
    public static final IconScene DOCUMENT = null;
    public static final IconScene HOME_PAGE = null;
    public static final IconScene LYNX = null;
    public static final IconScene MINUTES = null;
    public static final IconScene MQC = null;
    public static final IconScene QUICK_LAUNCH = null;
    public static final IconScene SYNC_BLOCK = null;
    public static final IconScene TEMPLATE = null;
    public static final IconScene TODO = null;
    public static final IconScene UNKNOW = null;
    public static final IconScene VC = null;
    public static final IconScene WIKI = null;
    public static final /* synthetic */ IconScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IconScene> getEntries() {
        return b;
    }

    static {
        IconScene r0 = new IconScene("UNKNOW", 0);
        UNKNOW = r0;
        IconScene r1 = new IconScene("TODO", 1);
        TODO = r1;
        IconScene r3 = new IconScene("SYNC_BLOCK", 2);
        SYNC_BLOCK = r3;
        IconScene r5 = new IconScene("LYNX", 3);
        LYNX = r5;
        IconScene r7 = new IconScene("DOCUMENT", 4);
        DOCUMENT = r7;
        IconScene r9 = new IconScene("VC", 5);
        VC = r9;
        IconScene r11 = new IconScene("MINUTES", 6);
        MINUTES = r11;
        IconScene r13 = new IconScene("WIKI", 7);
        WIKI = r13;
        IconScene r15 = new IconScene("MQC", 8);
        MQC = r15;
        IconScene r14 = new IconScene("HOME_PAGE", 9);
        HOME_PAGE = r14;
        IconScene r12 = new IconScene("QUICK_LAUNCH", 10);
        QUICK_LAUNCH = r12;
        IconScene r10 = new IconScene("BITABLE", 11);
        BITABLE = r10;
        IconScene r8 = new IconScene("TEMPLATE", 12);
        TEMPLATE = r8;
        IconScene[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static IconScene[] values() {
        return (IconScene[]) a.clone();
    }

    public static IconScene valueOf(String r1) {
        return (IconScene) a.a(IconScene.class, r1);
    }

    public IconScene(String r1, int r2) {
        super(r1, r2);
    }
}
