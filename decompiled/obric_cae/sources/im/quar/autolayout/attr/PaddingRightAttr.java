package im.quar.autolayout.attr;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class PaddingRightAttr extends AutoAttr<View> {
    public PaddingRightAttr(int r8) {
        super(r8);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public int attrVal() {
        return 2048;
    }

    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public void execute2(View r8, int r10) {
        r8.setPadding(r8.getPaddingLeft(), r8.getPaddingTop(), r10, r8.getPaddingBottom());
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public /* bridge */ /* synthetic */ void execute(View r8, int r10) {
        execute2(r8, r10);
    }
}
