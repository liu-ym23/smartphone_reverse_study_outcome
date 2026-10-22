package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu r1);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r1);
    }

    public PopupMenu(Context r3, View r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, 0);
    }

    public PopupMenu(Context r7, View r8, int r9) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r9, ZeusTransformUtils.mapRes(R.attr.popupMenuStyle, "attr", "popupMenuStyle"), 0);
    }

    public PopupMenu(Context r10, View r11, int r12, int r13, int r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r3, "com.obric.memorydata.plugin");
        this.mAnchor = r11;
        MenuBuilder r4 = new MenuBuilder(r3);
        this.mMenu = r4;
        r4.setCallback(new AnonymousClass1(this));
        MenuPopupHelper r15 = new MenuPopupHelper(r3, r4, r11, false, r13, r14);
        this.mPopup = r15;
        r15.setGravity(r12);
        r15.setOnDismissListener(new AnonymousClass2(this));
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener != null) goto L6;
        final View r1 = this.mAnchor;
        this.mDragListener = new AnonymousClass3(this, r1);
    L6:
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    ListView getMenuListView() {
        if (this.mPopup.isShowing() == true) goto L7;
        return null;
    L7:
        return this.mPopup.getListView();
    }

    public void inflate(int r2) {
        getMenuInflater().inflate(r2, this.mMenu);
    }

    public void setForceShowIcon(boolean r1) {
        this.mPopup.setForceShowIcon(r1);
    }

    public void setGravity(int r1) {
        this.mPopup.setGravity(r1);
    }

    public void setOnDismissListener(OnDismissListener r3) {
        this.mOnDismissListener = (OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, OnDismissListener.class, "com.obric.memorydata.plugin");
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r3) {
        this.mMenuItemClickListener = (OnMenuItemClickListener) ZeusTransformUtils.wrapperContextForParams(r3, OnMenuItemClickListener.class, "com.obric.memorydata.plugin");
    }

    public void show() {
        this.mPopup.show();
    }
}
