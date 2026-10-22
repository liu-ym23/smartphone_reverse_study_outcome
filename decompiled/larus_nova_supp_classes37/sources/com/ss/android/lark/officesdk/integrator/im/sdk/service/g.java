package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.jvm.internal.Intrinsics;
import okb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements i {
    public final /* synthetic */ KVRepo a;

    public final int a() {
        Intrinsics.checkNotNullParameter("key_translate_times_new", "key");
        return this.a.getInt("key_translate_times_new", 0);
    }

    public final boolean e() {
        Intrinsics.checkNotNullParameter("android_file_upload_file_descriptor_config", "key");
        return this.a.getBoolean("android_file_upload_file_descriptor_config", true);
    }

    public final String getString() {
        Intrinsics.checkNotNullParameter("chatter_info", "key");
        return this.a.getString("chatter_info", null);
    }

    public g(com.ss.android.lark.storage.kv.repo.a r1) {
        this.a = r1;
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter("chatter_info", "key");
        this.a.putString("chatter_info", r3);
    }

    public final void putInt(int r3) {
        Intrinsics.checkNotNullParameter("key_translate_times_new", "key");
        this.a.putInt("key_translate_times_new", r3);
    }
}
