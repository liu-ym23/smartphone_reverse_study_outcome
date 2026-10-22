package com.ss.android.lark.image.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.image.api.IRequestCreator;
import rkb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class RequestCreatorContainer extends RequestCreator {
    @Override // com.ss.android.lark.image.impl.RequestCreator, com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator load(Object r4) {
        Context r0 = this.mContext;
        if (r0 == null) goto L5;
        RequestCreator r1 = new RequestCreator(this.mImageLoader, r0);
    L13:
        return r1.load(r4);
    L5:
        Fragment r2 = this.mSupportFragment;
        if (r2 == null) goto L8;
        r1 = new RequestCreator(this.mImageLoader, r2);
        goto L13
    L8:
        android.app.Fragment r3 = this.mFragment;
        if (r3 == null) goto L11;
        r1 = new RequestCreator(this.mImageLoader, r3);
        goto L13
    L11:
        r1 = null;
        goto L13
    }

    @Override // com.ss.android.lark.image.impl.RequestCreator, com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator load(Object r1) {
        return load(r1);
    }

    public RequestCreatorContainer(c r1, android.app.Fragment r2) {
        super(r1, r2);
    }

    public RequestCreatorContainer(c r1, Context r2) {
        super(r1, r2);
    }

    public RequestCreatorContainer(c r1, Fragment r2) {
        super(r1, r2);
    }
}
