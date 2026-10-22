package com.obric.aikernel.model_preset.impl.ipc;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.crash.event.EnsureReportData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetDecryptIPCProvider extends ContentProvider {
    public static final String AUTHORITY = "com.obric.aikernel.preset_decrypt.api";
    public static final Companion Companion = null;
    public static final String METHOD_GET_BINDER = "getBinder";
    private static final String TAG = "PresetDecryptIPCProvider";
    private final Lazy binder$delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PresetDecryptIPCProvider() {
        this.binder$delegate = LazyKt.lazy(PresetDecryptIPCProvider$binder$2.INSTANCE);
    }

    private final PresetDecryptIPCProvider$binder$2.AnonymousClass1 getBinder() {
        return (PresetDecryptIPCProvider$binder$2.AnonymousClass1) this.binder$delegate.getValue();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        if (Intrinsics.areEqual(r10, METHOD_GET_BINDER) == false) goto L6;
        Bundle r13 = new Bundle();
        r13.putBinder("binder", getBinder());
        return r13;
    L6:
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return 0;
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
        return 0;
    }
}
