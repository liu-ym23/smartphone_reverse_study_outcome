package com.ss.android.lark.chameleon.widgetv2.emptyview;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EmptyMediator {
    private static final String TAG = "EmptyViewMediator";
    private View mContentView;
    private EmptyStateSource mEmptyStateSource;
    private EmptyViewController mEmptyView;

    public EmptyStateSource getEmptyStateSource() {
        return this.mEmptyStateSource;
    }

    public void updateEmptyState(EmptyStateSource.EmptyState r5) {
        j.e(TAG, "updateEmptyState");
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r5.getState();
        j.e(TAG, "emptyState.getState:" + r0);
        if (r0 != 0) goto L8;
    L55:
        this.mEmptyView.show();
        View r6 = this.mContentView;
        if (r6 == null) goto L58;
        r6.setVisibility(4);
    L58:
        this.mEmptyView.showLoading();
        return;
    L8:
        if (r0 != 1) goto L10;
        this.mEmptyView.show();
        View r7 = this.mContentView;
        if (r7 == null) goto L54;
        r7.setVisibility(4);
    L54:
        this.mEmptyView.showNoContent();
        return;
    L10:
        if (r0 != 2) goto L12;
        this.mEmptyView.hide();
        View r8 = this.mContentView;
        if (r8 == null) goto L68;
        r8.setVisibility(0);
        return;
    L68:
        return;
    L12:
        if (r0 == 3) goto L44;
        if (r0 != 4) goto L15;
        this.mEmptyView.show();
        View r9 = this.mContentView;
        if (r9 == null) goto L43;
        r9.setVisibility(4);
    L43:
        this.mEmptyView.showNoNetworkError();
        return;
    L15:
        if (r0 != 5) goto L17;
        this.mEmptyView.show();
        View r10 = this.mContentView;
        if (r10 == null) goto L39;
        r10.setVisibility(4);
    L39:
        this.mEmptyView.showNoFound();
        return;
    L17:
        if (r0 == 99) goto L32;
        switch(r0) {
            case 7: goto L28;
            case 8: goto L55;
            case 9: goto L24;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        j.b(TAG, "onChanged: unknown state = " + r0);
        return;
    L20:
        this.mEmptyView.show();
        View r11 = this.mContentView;
        if (r11 == null) goto L23;
        r11.setVisibility(4);
    L23:
        this.mEmptyView.showNoSupport();
        return;
    L24:
        this.mEmptyView.show();
        View r12 = this.mContentView;
        if (r12 == null) goto L27;
        r12.setVisibility(4);
    L27:
        this.mEmptyView.showWikiDeleted();
        return;
    L28:
        this.mEmptyView.show();
        View r13 = this.mContentView;
        if (r13 == null) goto L31;
        r13.setVisibility(4);
    L31:
        this.mEmptyView.showTimeout();
        return;
    L32:
        this.mEmptyView.show();
        View r14 = this.mContentView;
        if (r14 == null) goto L35;
        r14.setVisibility(4);
    L35:
        this.mEmptyView.showNoPermission();
        return;
    L44:
        this.mEmptyView.show();
        View r1 = this.mContentView;
        if (r1 == null) goto L47;
        r1.setVisibility(4);
    L47:
        this.mEmptyView.showLoadError(r5.getError());
    }

    public EmptyMediator(Context r1, EmptyViewController r2, View r3) {
        this.mEmptyView = r2;
        this.mContentView = r3;
    }

    public EmptyMediator(Context r1, LifecycleOwner r2, EmptyViewController r3, View r4) {
        this.mEmptyView = r3;
        this.mContentView = r4;
        EmptyStateSource r5 = new EmptyStateSource(r1);
        this.mEmptyStateSource = r5;
        r5.observe(r2, new AnonymousClass1(this));
    }
}
