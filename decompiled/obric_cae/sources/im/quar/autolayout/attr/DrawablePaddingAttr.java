package im.quar.autolayout.attr;

import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class DrawablePaddingAttr extends AutoAttr<TextView> {
    public DrawablePaddingAttr(int r8) {
        super(r8);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public int attrVal() {
        return 131072;
    }

    /* JADX INFO: renamed from: execute, reason: avoid collision after fix types in other method */
    public void execute2(TextView r8, int r10) {
        r8.setCompoundDrawablePadding(r10);
    }

    @Override // im.quar.autolayout.attr.AutoAttr
    public /* bridge */ /* synthetic */ void execute(TextView r8, int r10) {
        execute2(r8, r10);
    }
}
