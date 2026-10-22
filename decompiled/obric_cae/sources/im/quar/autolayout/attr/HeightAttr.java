package im.quar.autolayout.attr;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class HeightAttr extends AutoAttr<ViewGroup.LayoutParams> {
    public HeightAttr(int r8) {
        super(r8);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public int attrVal() {
        return 2;
    }

    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public void execute2(ViewGroup.LayoutParams r8, int r10) {
        r8.height = r10;
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public /* bridge */ /* synthetic */ void execute(ViewGroup.LayoutParams r8, int r10) {
        execute2(r8, r10);
    }
}
