package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class NativeStorageImpl$Companion$1 extends FunctionReferenceImpl implements Function1<Context, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NativeStorageImpl$Companion$1 f7479a = null;

    static {
        f7479a = new NativeStorageImpl$Companion$1();
    }

    public NativeStorageImpl$Companion$1() {
        super(1, d.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final d invoke(Context r5) {
        return new d(r5);
    }
}
