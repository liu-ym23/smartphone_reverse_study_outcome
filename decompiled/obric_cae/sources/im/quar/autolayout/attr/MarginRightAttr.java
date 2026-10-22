package im.quar.autolayout.attr;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class MarginRightAttr extends AutoAttr<ViewGroup.MarginLayoutParams> {
    public MarginRightAttr(int r8) {
        super(r8);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public int attrVal() {
        return 128;
    }

    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public void execute2(ViewGroup.MarginLayoutParams r8, int r10) {
        r8.rightMargin = r10;
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public /* bridge */ /* synthetic */ void execute(ViewGroup.MarginLayoutParams r8, int r10) {
        execute2(r8, r10);
    }
}
