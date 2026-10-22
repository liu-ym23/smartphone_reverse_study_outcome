package com.obric.memorydata.memory.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.utils.v;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JI\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0016J4\u0010 \u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\fH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J/\u0010)\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010*J9\u0010+\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010,¨\u0006."}, d2 = {"Lcom/obric/memorydata/memory/provider/AILabProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "queryRecorderSettings", "isRecorderSettingsCallerRefused", "isRecorderProcessCaller", "getCallingPackages", "", "callingUid", "", "registerNotificationUri", "", "Landroid/database/MatrixCursor;", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "arg", "extras", "addProviderStatusRow", "matchCode", "privacyAllowed", OaidModel.KEY_ID, "key", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AILabProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final UriMatcher f10349b = null;
    private static final ConcurrentHashMap<String, a.C0509a> c = null;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0002J\f\u0010&\u001a\u00020\u0005*\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/provider/AILabProvider$Companion;", "", "<init>", "()V", "TAG", "", "QUERY_LOG_INTERVAL_MS", "", "AUTHORITY", "PATH_MEMORY_PERMISSION_STATUS", "METHOD_QUERY_MEMORY_REVIEW_ENTRY_ENABLED", "KEY_ENABLED", "URI_MATCHER", "Landroid/content/UriMatcher;", "SCREEN_MEMORY_URI_CODE", "", "VOICE_MEMORY_URI_CODE", "AI_LAB_STATUS_URI_CODE", "MEMORY_PERMISSION_STATUS_URI_CODE", "AUTO_MEMORY_URI_CODE", "AI_PROACTIVE_AGENT_URI_CODE", "RECORDER_CELLULAR_URI_CODE", "RECORDER_BLOCK_RULES_URI_CODE", "COLUMN_STATUS", "lastQueryLogSnapshots", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/memory/provider/AILabProvider$Companion$QueryLogSnapshot;", "logQueryResult", "", "uri", "Landroid/net/Uri;", "matchCode", "privacyAllowed", "", "permissionName", "status", "state", "Lcom/obric/memorydata/memory/lab/AILabPermissionState;", "toTargetKey", "QueryLogSnapshot", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.provider.AILabProvider$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/provider/AILabProvider$Companion$QueryLogSnapshot;", "", "status", "", "privacyAllowed", "", "schema", "Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "labVisible", "lastLogTimeMs", "", "<init>", "(IZLcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;ZJ)V", "getStatus", "()I", "getPrivacyAllowed", "()Z", "getSchema", "()Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "getLabVisible", "getLastLogTimeMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final class C0509a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f10350a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f10351b;
            private final AILabPermissionRepository.PermissionSchema c;
            private final boolean d;
            private final long e;

            public C0509a(int r1, boolean r2, AILabPermissionRepository.PermissionSchema r3, boolean r4, long r5) {
                this.f10350a = r1;
                this.f10351b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final int a() {
                return this.f10350a;
            }

            public final boolean b() {
                return this.f10351b;
            }

            public final AILabPermissionRepository.PermissionSchema c() {
                return this.c;
            }

            public final boolean d() {
                return this.d;
            }

            public final long e() {
                return this.e;
            }

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, C0509a.class) == true) goto L8;
                return false;
            L8:
                C0509a r8 = (C0509a) ZeusTransformUtils.preCheckCast(r7, C0509a.class, "com.obric.memorydata.plugin");
                if (this.f10350a == r8.f10350a) goto L12;
                return false;
            L12:
                if (this.f10351b == r8.f10351b) goto L15;
                return false;
            L15:
                if (this.c == r8.c) goto L18;
                return false;
            L18:
                if (this.d == r8.d) goto L21;
                return false;
            L21:
                if (this.e == r8.e) goto L23;
                return false;
            L23:
                return true;
            }

            public int hashCode() {
                int r0 = ((Integer.hashCode(this.f10350a) * 31) + Boolean.hashCode(this.f10351b)) * 31;
                AILabPermissionRepository.PermissionSchema r1 = this.c;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return ((((r0 + r2) * 31) + Boolean.hashCode(this.d)) * 31) + Long.hashCode(this.e);
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "QueryLogSnapshot(status=" + this.f10350a + ", privacyAllowed=" + this.f10351b + ", schema=" + this.c + ", labVisible=" + this.d + ", lastLogTimeMs=" + this.e + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a(int r1) {
            switch(r1) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                case 8: goto L4;
                default: goto L3;
            };
        L3:
            return "unknown";
        L4:
            return "recorder_settings/block_rules";
        L5:
            return "recorder_settings/cellular";
        L6:
            return "ai_proactive_agent";
        L7:
            return "auto_memory";
        L8:
            return "memory_permission_status";
        L9:
            return "ai_lab_status";
        L10:
            return "voice_memory";
        L11:
            return "screen_memory";
        }

        public static final /* synthetic */ String a(a r0, int r1) {
            return r0.a(r1);
        }

        private final void a(Uri r10, int r11, boolean r12, String r13, int r14, com.obric.memorydata.memory.lab.d r15) {
            long r5 = System.currentTimeMillis();
            C0509a r9 = (C0509a) ZeusTransformUtils.preCheckCast(AILabProvider.a().get(r13), C0509a.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L5;
        L16:
            boolean r16 = true;
        L17:
            if (r16 == true) goto L19;
            return;
        L19:
            ((Map) ZeusTransformUtils.preCheckCast(AILabProvider.a(), Map.class, "com.obric.memorydata.plugin")).put(r13, new C0509a(r14, r12, r15.a(), r15.c(), r5));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "query result permission=" + r13 + " status=" + r14 + " uri=" + r10 + " privacyAllowed=" + r12 + " matchCode=" + r11 + " schema=" + r15.a() + " labVisible=" + r15.c(), false, 4, null);
            return;
        L5:
            if (r9.a() != r14) goto L16;
            if (r9.b() != r12) goto L16;
            if (r9.c() != r15.a()) goto L16;
            if (r9.d() != r15.c()) goto L16;
            if ((r5 - r9.e()) >= 30000) goto L16;
            r16 = false;
            goto L17
        }

        public static final /* synthetic */ void a(a r0, Uri r1, int r2, boolean r3, String r4, int r5, com.obric.memorydata.memory.lab.d r6) {
            r0.a(r1, r2, r3, r4, r5, r6);
        }
    }

    static {
        f10348a = new a(null);
        UriMatcher r0 = new UriMatcher(-1);
        f10349b = r0;
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "screen_memory", 1);
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "voice_memory", 2);
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "ai_lab_status", 3);
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "memory_permission_status", 4);
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "auto_memory", 5);
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "ai_proactive_agent", 6);
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "recorder_settings/cellular", 7);
        r0.addURI("com.obric.memorydata.memory.ailabprovider", "recorder_settings/block_rules", 8);
        c = new ConcurrentHashMap();
    }

    public AILabProvider() {
    }

    private final Cursor a(Uri r6) {
        f r0 = f.f10364a;
        String r7 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        g r8 = r0.a(r7, new $$Lambda$AILabProvider$u3J3U0kBx199XYlpNsgrRa87aI(this), $$Lambda$AILabProvider$x8LwCYRWCObUeNrh6TiSkexahNY.INSTANCE, $$Lambda$AILabProvider$jzplKrjlm_794uXTwyEoBIEDNs.INSTANCE);
        MatrixCursor r1 = new MatrixCursor((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r8.a(), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.addRow((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Uri r9 = Uri.parse(r8.c());
        Intrinsics.checkNotNullExpressionValue(r9, "parse(...)");
        a(r1, r9);
        return (Cursor) ZeusTransformUtils.preCheckCast(r1, Cursor.class, "com.obric.memorydata.plugin");
    }

    private final List<String> a(int r3) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        PackageManager r4 = r2.getPackageManager();
        if (r4 == null) goto L9;
        String[] r5 = r4.getPackagesForUid(r3);
        if (r5 == null) goto L9;
        List<String> r6 = ArraysKt.toList(r5);
    L10:
        if (r6 == null) goto L12;
        return r6;
    L12:
        return CollectionsKt.emptyList();
    L9:
        r6 = null;
        goto L10
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return c;
    }

    private static final Unit a(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        RunLog.INSTANCE.warn("AILabProvider", "query memory review entry enabled failed", r3);
        return Unit.INSTANCE;
    }

    private final void a(MatrixCursor r3, Uri r4) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        ContentResolver r5 = r2.getContentResolver();
        if (r5 == null) goto L9;
        r3.setNotificationUri(r5, r4);
        return;
    L9:
        return;
    }

    private final void a(MatrixCursor r8, Uri r9, int r10, boolean r11, int r12, String r13) {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "query context is null, uri=" + r9 + " targetKey=" + r13, null, 4, null);
    L5:
        com.obric.memorydata.memory.lab.d r6 = (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin");
        int r5 = AILabPermissionRepository.f10236a.a(r13, r6);
        r8.addRow(new Object[]{Integer.valueOf(r12), Integer.valueOf(r5)});
        a.a(f10348a, r9, r10, r11, r13, r5, r6);
    }

    public static final /* synthetic */ boolean a(AILabProvider r0) {
        return r0.c();
    }

    private static final boolean a(AILabProvider r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(Boolean.valueOf(ak.f13164a.a(r2)));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r4) == false) goto L11;
        r4 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final boolean b() {
        int r0 = Binder.getCallingUid();
        e r1 = e.f10363a;
        boolean r2 = false;
        if (r0 != 1000) goto L5;
        boolean r4 = true;
    L7:
        if (r0 != Process.myUid()) goto L9;
        r2 = true;
    L9:
        boolean r10 = r1.a(r4, r2, a(r0), new $$Lambda$AILabProvider$AC98bQZdkB2vYNt0v3Z0qyvQY9g(this));
        if (r10 == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "recorder settings query refused", null, 4, null);
    L13:
        return !r10;
    L5:
        r4 = false;
        goto L7
    }

    private static final boolean b(AILabProvider r0) {
        return r0.b();
    }

    private final boolean c() {
        int r0 = Binder.getCallingUid();
        e r1 = e.f10363a;
        boolean r2 = true;
        if (r0 != 1000) goto L5;
        boolean r4 = true;
    L7:
        if (r0 == Process.myUid()) goto L11;
        r2 = false;
    L11:
        return r1.a(r4, r2, a(r0));
    L5:
        r4 = false;
        goto L7
    }

    private static final boolean d() {
        return RecommendApi.INSTANCE.getScreenObservationCellularEnabled();
    }

    private static final List e() {
        return RecommendApi.INSTANCE.getBlockMemoryRuleSnapshots();
    }

    private static final Unit f() {
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("recorder_debug_switch_read_failed", "读取录音机环境人声调试开关失败，回退调用方准入判断", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$5GFVNAXThT5kh4nG2sNgSxnuD_Y() {
        return f();
    }

    public static /* synthetic */ boolean lambda$AC98bQZdkB2vYNt0v3Z0qyvQY9g(AILabProvider r0, String r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$jzplKrjlm_-794uXTwyEoBIEDNs, reason: not valid java name */
    public static /* synthetic */ List m744lambda$jzplKrjlm_794uXTwyEoBIEDNs() {
        return e();
    }

    /* JADX INFO: renamed from: lambda$s9d0i5-RPvS5z1BmHA1xJ7fEU0s, reason: not valid java name */
    public static /* synthetic */ Unit m745lambda$s9d0i5RPvS5z1BmHA1xJ7fEU0s(Throwable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$u3J3U0kBx1-99XYlpNsgrRa87aI, reason: not valid java name */
    public static /* synthetic */ boolean m746lambda$u3J3U0kBx199XYlpNsgrRa87aI(AILabProvider r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$x8LwCYRWCObUeNrh6TiSkexahNY() {
        return d();
    }

    public Bundle call(String r9, String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "method");
        if (Intrinsics.areEqual(r9, "queryMemoryReviewEntryEnabled") == false) goto L5;
        Bundle r12 = new Bundle();
        r12.putBoolean("enabled", c.f10361a.a((Function0) ZeusTransformUtils.preCheckCast(new AILabProvider$call$1$enabled$1(ak.f13164a), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AILabProvider$call$1$enabled$2(com.obric.memorydata.memory.review.c.f10378a), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AILabProvider$call$1$enabled$3(com.obric.memorydata.memory.review.c.f10378a), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AILabProvider$call$1$enabled$4(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AILabProvider$call$1$enabled$5(com.obric.memorydata.database.c.c.f8852a), Function0.class, "com.obric.memorydata.plugin"), $$Lambda$AILabProvider$5GFVNAXThT5kh4nG2sNgSxnuD_Y.INSTANCE, $$Lambda$AILabProvider$s9d0i5RPvS5z1BmHA1xJ7fEU0s.INSTANCE));
        return r12;
    L5:
        return super.call(r9, r10, r11);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "AILabProvider created", false, 4, null);
        return true;
    }

    public Cursor query(Uri r11, String[] r12, String r13, String[] r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        int r3 = f10349b.match(r11);
        if (r3 == 7) goto L28;
        if (r3 == 8) goto L28;
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L9;
        AILabPermissionRepository.f10236a.a(r16);
    L10:
        boolean r17 = v.f11566a.b();
        a r0 = f10348a;
        String r18 = a.a(r0, r3);
        if (ak.f13164a.a() == true) goto L25;
        MatrixCursor r19 = new MatrixCursor(new String[]{"_id", "status"});
        switch(r3) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L14;
        };
    L14:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "query result permission=unknown status=error uri=" + r11 + " matchCode=" + r3, null, 4, null);
        throw new IllegalArgumentException("Unknown URI: " + r11);
    L16:
        int r5 = 6;
        String r6 = "ai_proactive_agent";
    L22:
        a(r19, r11, r3, r17, r5, r6);
    L24:
        return (Cursor) ZeusTransformUtils.preCheckCast(r19, Cursor.class, "com.obric.memorydata.plugin");
    L17:
        r5 = 5;
        r6 = "auto_memory";
        goto L22
    L18:
        r19.addRow(new Object[]{4, Integer.valueOf(r17 ? 1 : 0)});
        a.a(r0, r11, r3, r17, "memory_permission_status", r17 ? 1 : 0, (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin"));
        goto L24
    L19:
        r5 = 3;
        r6 = "ai_lab_status";
        goto L22
    L20:
        r5 = 2;
        r6 = "voice_memory";
        goto L22
    L21:
        r5 = 1;
        r6 = "screen_memory";
        goto L22
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "query result permission=" + r18 + " status=refused uri=" + r11 + " privacyAllowed=" + r17, null, 4, null);
        throw new SecurityException("Permission denied: com.obric.memorydata.memory.READ_AI_LAB_SETTINGS");
    L9:
        AILabProvider r110 = (AILabProvider) ZeusTransformUtils.preCheckCast(this, AILabProvider.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "query context is null, cannot ensure repository initialized", null, 4, null);
    L28:
        return a(r11);
    }

    public int update(Uri r7, ContentValues r8, String r9, String[] r10) {
        Intrinsics.checkNotNullParameter(r7, "uri");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabProvider", "update ignored, provider status is managed by AILabPermissionRepository, uri=" + r7, null, 4, null);
        return 0;
    }
}
