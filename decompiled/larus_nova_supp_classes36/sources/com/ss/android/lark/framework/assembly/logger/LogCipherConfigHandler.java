package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LogCipherConfigHandler extends AbstractBaseSettingHandler {
    public static final LogCipherConfigHandler i = null;
    public static LogCipherConfig j;
    public static String k;

    @AppConfig(key = "sdk_log_encryption")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/framework/assembly/logger/LogCipherConfigHandler$LogCipherConfig;", "", "keyId", "", "publicKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKeyId", "()Ljava/lang/String;", "getPublicKey", "logger-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class LogCipherConfig {

        @SerializedName("key_id")
        private final String keyId;

        @SerializedName("encoded_public_key")
        private final String publicKey;

        public final String getKeyId() {
            return this.keyId;
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public LogCipherConfig(String r1, String r2) {
            this.keyId = r1;
            this.publicKey = r2;
        }
    }

    @AppSettingPlugin
    public static final class a implements npb.a {
        public a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            return SetsKt.mutableSetOf(new LogCipherConfigHandler[]{LogCipherConfigHandler.i});
        }

        @Override // npb.a
        public final String getTag() {
            return "LogCipherConfigHandler";
        }
    }

    static {
        i = new LogCipherConfigHandler();
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "sdk_log_encryption";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "LogCipherConfigHandler";
    }

    public LogCipherConfigHandler() {
    }

    public static final void j(LogCipherConfigHandler r2, Context r3, String r4, boolean r5) {
        r2.getClass();
        if (Intrinsics.areEqual(r4, k) == true) goto L12;
        k = r4;     // Catch: Throwable -> L7
        com.ss.android.lark.storage.kv.flash.d r1 = com.ss.android.lark.storage.kv.flash.c.b;     // Catch: Throwable -> L7
        com.ss.android.lark.storage.kv.flash.c.b.a(r3).b(r4);     // Catch: Throwable -> L7
        Log.d("LogCipherConfigHandler", "config update, fromRemote= " + r5 + "  config=" + r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.e("LogCipherConfigHandler", "save log cipher config failed, error: " + th.getMessage());
        return;
    }
}
