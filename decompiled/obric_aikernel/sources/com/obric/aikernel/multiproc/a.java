package com.obric.aikernel.multiproc;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aikernel.InferEntryHolder;
import com.obric.aikernel.core.data.IdlKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class a extends ContentProvider {
    public a() {
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        if (Intrinsics.areEqual(r10, IdlKeys.Method_QuerySubProc) == false) goto L8;
        Bundle r13 = new Bundle();
        if (getContext() == null) goto L9;
        r13.putBinder(IdlKeys.Args_InferBinder, InferEntryHolder.b(InferEntryHolder.f4392a, null, 1, null));
        return r13;
    L9:
        return r13;
    L8:
        return super.call(r10, r11, r12);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return -1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return -1;
    }
}
