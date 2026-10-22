package com.obric.memorydata.memory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.database.entity.AssistantChatMessageEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.sdk.memory.State;
import com.obric.memorydata.sdk.server.IPoolService;
import com.obric.memorydata.sdk.service.BinderCode;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/MemoryService;", "Lcom/obric/memorydata/sdk/server/IPoolService;", "<init>", "()V", "provideBinderCode", "Lcom/obric/memorydata/sdk/service/BinderCode;", "provideBinder", "Landroid/os/IBinder;", "Companion", "MemoryBinder", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryService implements IPoolService {
    public static final a Companion = null;
    public static final String TAG = "MemoryService";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/MemoryService$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/MemoryService$MemoryBinder;", "Lcom/obric/memorydata/sdk/memory/IMemoryService$Stub;", "<init>", "()V", "registerMemoryCallback", "", "callback", "Lcom/obric/memorydata/sdk/memory/IMemoryCallback;", "saveAssistantChatMemory", "type", "", SlardarSettingsConstants.PERF_KEY_MEMORY, "extras", "Landroid/os/Bundle;", "getDialogueMemoryEnableState", "", "dialogueMemoryEnable", "syncAssistantChat", "json", "isEnterpriseAccount", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b extends com.obric.memorydata.sdk.memory.b.a {

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/memory/MemoryService$MemoryBinder$registerMemoryCallback$1$deathRecipient$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.obric.memorydata.sdk.memory.a f10044a;

            a(com.obric.memorydata.sdk.memory.a r3) {
                this.f10044a = (com.obric.memorydata.sdk.memory.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.sdk.memory.a.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryService.TAG, "binderDied", null, 4, null);
                x.f11587a.a(this.f10044a);
            }
        }

        public b() {
        }

        private static final void a(Bundle r21, String r22, String r23) {
            String r0 = r21.getString("memoryLogId");
            if (r0 != null) goto L5;
            r0 = "19700101000002";
        L5:
            com.obric.memorydata.memory.memoryentity.c r1 = com.obric.memorydata.memory.memoryentity.c.f10314a;
            JSONObject r3 = new JSONObject(r23);
            MemoryEntity r15 = com.obric.memorydata.memory.memoryentity.c.a(r1, r22, r3, null, null, r0, null, null, 0, 236, null);
            if (r15 == null) goto L13;
            MemoryEntity r16 = MemoryEntityManager.INSTANCE.index(r15);
            String r13 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
            x r12 = x.f11587a;
            if (r16 == null) goto L10;
            State r2 = State.SUCCESS_UPDATE;
        L11:
            x.a(r12, r13, r2, r15, r16, false, null, 32, null);
            return;
        L10:
            r2 = State.SUCCESS_NEW;
            goto L11
        }

        private static final void b(String r10) {
            AssistantChatMessageEntity r11 = AssistantChatMessageEntity.Companion.a(r10);     // Catch: Exception -> L10
            if (r11 == null) goto L13;
            long r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAssistantChatMessageDao().insertIgnore(r11);     // Catch: Exception -> L10
            if (r2 != (-1)) goto L8;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryService.TAG, "skip duplicate AssistantChatMessageEntity messageId: " + r11.getMessageId(), false, 4, null);     // Catch: Exception -> L10
            goto L13
        L8:
            RunLog.INSTANCE.debug(MemoryService.TAG, "save AssistantChatMessageEntity: " + com.obric.memorydata.utils.v.a(r11, false, 1, null));     // Catch: Exception -> L10
            AwarenessManager.INSTANCE.dispatchAwarenessEvent("ai_proactive_assistant_chat", MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_table", "AssistantChatMessageEntity"), TuplesKt.to("raw_id", Long.valueOf(r2))}));     // Catch: Exception -> L10
        L13:
            return;
        L10:
            e = move-exception;
            RunLog.INSTANCE.error(MemoryService.TAG, "syncAssistantChat error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final boolean b() {
            if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "smart_memory_enabled", 0) != 1) goto L5;
            boolean r6 = true;
        L6:
            boolean r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getStringSet("smart_memory_disable_packages", SetsKt.emptySet()).contains("assistant.history");
            if (r6 == false) goto L11;
            if (r0 == false) goto L10;
            return false;
        L10:
            return true;
        L11:
            return false;
        L5:
            r6 = false;
            goto L6
        }

        private final boolean c() {
            return UserSettings.INSTANCE.isEnterpriseAccount();
        }

        public static /* synthetic */ void lambda$NOoAoU08OxQbc1qEk8LgKvVyGPk(String r0) {
            b(r0);
        }

        public static /* synthetic */ void lambda$uEMfTTeDhtSpb03gMWwr1AoWIRw(Bundle r0, String r1, String r2) {
            a(r0, r1, r2);
        }

        @Override // com.obric.memorydata.sdk.memory.b
        public void a(com.obric.memorydata.sdk.memory.a r10) {
            com.obric.memorydata.sdk.memory.a r11 = (com.obric.memorydata.sdk.memory.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.sdk.memory.a.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryService.TAG, "registerMemoryCallback " + r11, null, 4, null);
            if (c() == false) goto L8;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryService.TAG, "ignore registerMemoryCallback for enterprise account", false, 4, null);
            if (r11 == null) goto L12;
            r11.a(false);
            return;
        L12:
            return;
        L8:
            if (r11 == null) goto L10;
            r11.a(b());
            a r9 = new a(r11);
            r11.asBinder().linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r9, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);
            x.f11587a.a(r11, (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r9, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"));
            return;
        L10:
            x.a(x.f11587a, null, null, 2, null);
        }

        @Override // com.obric.memorydata.sdk.memory.b
        public void a(final String r7) {
            Intrinsics.checkNotNullParameter(r7, "json");
            if (c() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryService.TAG, "ignore syncAssistantChat for enterprise account", false, 4, null);
            return;
        L6:
            RunLog.INSTANCE.debug(MemoryService.TAG, "syncAssistantChat " + r7);
            if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L9;
            return;
        L9:
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$MemoryService$b$NOoAoU08OxQbc1qEk8LgKvVyGPk(r7));
        }

        @Override // com.obric.memorydata.sdk.memory.b
        public void a(final String r7, final String r8, final Bundle r9) {
            Intrinsics.checkNotNullParameter(r7, "type");
            Intrinsics.checkNotNullParameter(r8, SlardarSettingsConstants.PERF_KEY_MEMORY);
            Intrinsics.checkNotNullParameter(r9, "extras");
            if (c() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryService.TAG, "ignore saveAssistantChatMemory for enterprise account", false, 4, null);
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryService.TAG, "saveAssistantChatMemory " + r7 + ' ' + com.obric.memorydata.utils.q.f13259a.b(r8), false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L9;
            return;
        L9:
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$MemoryService$b$uEMfTTeDhtSpb03gMWwr1AoWIRw(r9, r7, r8));
        }

        @Override // com.obric.memorydata.sdk.memory.b
        public boolean a() {
            if (c() == false) goto L6;
            return false;
        L6:
            if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L9;
            return false;
        L9:
            return b();
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryService() {
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onBind(Intent r1) {
        IPoolService.a.a(this, r1);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onCreate() {
        IPoolService.a.a(this);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onDestroy() {
        IPoolService.a.b(this);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public boolean onUnbind(Intent r1) {
        return IPoolService.a.b(this, r1);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public IBinder provideBinder() {
        return (IBinder) ZeusTransformUtils.preCheckCast(new b(), IBinder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public BinderCode provideBinderCode() {
        return BinderCode.MEMORY;
    }
}
