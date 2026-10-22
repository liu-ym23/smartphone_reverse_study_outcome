package wd;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface e {
    View getView();

    void onHide();

    void onLoad();

    void onShow();

    boolean onTriggerAnimation(long r1);

    void onUnload();

    void onViewAttached(c r1);

    void onViewDetached();

    void onViewWillAttach(c r1);

    void onViewWillDetach();
}
