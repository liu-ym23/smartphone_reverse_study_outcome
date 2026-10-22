package com.larus.doc.sdk.impl.service;

import com.larus.office.OfficeInputParam;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n39.g;
import n39.j;
import n39.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u00020\u0011J\u0010\u00104\u001a\u0002052\b\b\u0002\u00103\u001a\u00020\u0011J\u0010\u00106\u001a\u0002072\b\b\u0002\u00103\u001a\u00020\u0011J\u0010\u00108\u001a\u0002092\b\b\u0002\u00103\u001a\u00020\u0011J\u0010\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u000102J\u0010\u0010=\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u000102J\u0010\u0010>\u001a\u00020;2\b\u0010?\u001a\u0004\u0018\u000109J\u0010\u0010@\u001a\u00020;2\b\u0010?\u001a\u0004\u0018\u000109J\u0006\u00108\u001a\u000209J\u0010\u0010A\u001a\u00020;2\b\u0010B\u001a\u0004\u0018\u000105J\u0010\u0010C\u001a\u00020;2\b\u0010B\u001a\u0004\u0018\u000105J\u0010\u0010D\u001a\u00020E2\b\b\u0002\u00103\u001a\u00020\u0011J\u0010\u0010F\u001a\u00020;2\b\u0010G\u001a\u0004\u0018\u00010EJ\u0010\u0010H\u001a\u00020;2\b\u0010G\u001a\u0004\u0018\u00010EJ\u0010\u0010I\u001a\u00020;2\b\u0010J\u001a\u0004\u0018\u000107J\u0010\u0010K\u001a\u00020;2\b\u0010J\u001a\u0004\u0018\u000107J\u001a\u0010N\u001a\u00020;2\b\u0010O\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010P\u001a\u00020\u0011J\u0012\u0010Q\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010P\u001a\u00020\u0011J\u001a\u0010R\u001a\u00020;2\b\u0010S\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010P\u001a\u00020\u0011J\u0012\u0010T\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010P\u001a\u00020\u0011J\u001a\u0010U\u001a\u00020;2\b\u0010V\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010P\u001a\u00020\u0011J\u0012\u0010W\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010P\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b.\u0010/R\u001c\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010M0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/larus/doc/sdk/impl/service/ServiceManager;", "", "<init>", "()V", "inputParam", "Lcom/larus/office/OfficeInputParam;", "getInputParam", "()Lcom/larus/office/OfficeInputParam;", "setInputParam", "(Lcom/larus/office/OfficeInputParam;)V", "docState", "Lcom/larus/doc/sdk/api/DocStateInfo;", "getDocState", "()Lcom/larus/doc/sdk/api/DocStateInfo;", "setDocState", "(Lcom/larus/doc/sdk/api/DocStateInfo;)V", "DEFAULT_DOC_KEY", "", "hostBizAbilityProvider", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/doc/sdk/api/IHostBizAbilityProvider;", "foldStatusListener", "Lcom/larus/doc/sdk/api/IChatInputFoldStatusListener;", "chatServiceDelegate", "Lcom/larus/doc/sdk/impl/service/ChatServiceDelegate;", "getChatServiceDelegate", "()Lcom/larus/doc/sdk/impl/service/ChatServiceDelegate;", "chatServiceDelegate$delegate", "Lkotlin/Lazy;", "docModeServiceDelegate", "Lcom/larus/doc/sdk/impl/service/DocModeServiceDelegate;", "getDocModeServiceDelegate", "()Lcom/larus/doc/sdk/impl/service/DocModeServiceDelegate;", "docModeServiceDelegate$delegate", "loadingDocStateServiceDelegate", "Lcom/larus/doc/sdk/impl/service/LoadingDocStateServiceDelegate;", "getLoadingDocStateServiceDelegate", "()Lcom/larus/doc/sdk/impl/service/LoadingDocStateServiceDelegate;", "loadingDocStateServiceDelegate$delegate", "loadingServiceDelegate", "Lcom/larus/doc/sdk/impl/service/LoadingServiceDelegate;", "getLoadingServiceDelegate", "()Lcom/larus/doc/sdk/impl/service/LoadingServiceDelegate;", "loadingServiceDelegate$delegate", "operationServiceDelegate", "Lcom/larus/doc/sdk/impl/service/OperationServiceDelegate;", "getOperationServiceDelegate", "()Lcom/larus/doc/sdk/impl/service/OperationServiceDelegate;", "operationServiceDelegate$delegate", "getChatService", "Lcom/larus/doc/sdk/api/IChatService;", "docLogicKey", "getLoadingDocStateService", "Lcom/larus/doc/sdk/api/ILoadingDocStateService;", "getOperationService", "Lcom/larus/doc/sdk/api/ICommonOperationService;", "getDocModeService", "Lcom/larus/doc/sdk/api/IDocModeService;", "addChatService", "", "chatService", "removeChatService", "addDocModeService", "docModeService", "removeDocModeService", "addLoadingDocStateService", "loadingDocStateService", "removeLoadingDocStateService", "getLoadingService", "Lcom/larus/office/base/page/ILoadingService;", "addLoadingService", "loadingService", "removeLoadingService", "addOperationService", "operationService", "removeOperationService", "docInfoProvider", "Lcom/larus/doc/sdk/api/IDocInfoProvider;", "setDocInfoProvider", "provider", "docKey", "getDocInfoProvider", "setHostBizAbilityProvider", "abilityProvider", "getHostBizAbilityProvider", "setChatInputFoldStatusListener", "listener", "getChatInputFoldStatusListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServiceManager {
    private static final String DEFAULT_DOC_KEY = "default_doc_logic_key";
    public static final ServiceManager INSTANCE = null;
    private static final Lazy chatServiceDelegate$delegate = null;
    private static ConcurrentHashMap<String, n39.f> docInfoProvider;
    private static final Lazy docModeServiceDelegate$delegate = null;
    private static n39.a docState;
    private static ConcurrentHashMap<String, n39.b> foldStatusListener;
    private static ConcurrentHashMap<String, j> hostBizAbilityProvider;
    private static OfficeInputParam inputParam;
    private static final Lazy loadingDocStateServiceDelegate$delegate = null;
    private static final Lazy loadingServiceDelegate$delegate = null;
    private static final Lazy operationServiceDelegate$delegate = null;

    private ServiceManager() {
    }

    public static /* synthetic */ OperationServiceDelegate a() {
        return operationServiceDelegate_delegate$lambda$4();
    }

    public static /* synthetic */ ChatServiceDelegate b() {
        return chatServiceDelegate_delegate$lambda$0();
    }

    public static /* synthetic */ LoadingServiceDelegate c() {
        return loadingServiceDelegate_delegate$lambda$3();
    }

    public static /* synthetic */ LoadingDocStateServiceDelegate d() {
        return loadingDocStateServiceDelegate_delegate$lambda$2();
    }

    public static /* synthetic */ DocModeServiceDelegate e() {
        return docModeServiceDelegate_delegate$lambda$1();
    }

    public final n39.a getDocState() {
        return null;
    }

    public final void setDocState(n39.a r1) {
    }

    static {
        INSTANCE = new ServiceManager();
        hostBizAbilityProvider = new ConcurrentHashMap();
        foldStatusListener = new ConcurrentHashMap();
        chatServiceDelegate$delegate = LazyKt.lazy(new b());
        docModeServiceDelegate$delegate = LazyKt.lazy(new c());
        loadingDocStateServiceDelegate$delegate = LazyKt.lazy(new d());
        loadingServiceDelegate$delegate = LazyKt.lazy(new e());
        operationServiceDelegate$delegate = LazyKt.lazy(new f());
        docInfoProvider = new ConcurrentHashMap();
    }

    private static final ChatServiceDelegate chatServiceDelegate_delegate$lambda$0() {
        return new ChatServiceDelegate();
    }

    private static final DocModeServiceDelegate docModeServiceDelegate_delegate$lambda$1() {
        return new DocModeServiceDelegate();
    }

    private final ChatServiceDelegate getChatServiceDelegate() {
        return (ChatServiceDelegate) chatServiceDelegate$delegate.getValue();
    }

    private final DocModeServiceDelegate getDocModeServiceDelegate() {
        return (DocModeServiceDelegate) docModeServiceDelegate$delegate.getValue();
    }

    private final LoadingDocStateServiceDelegate getLoadingDocStateServiceDelegate() {
        return (LoadingDocStateServiceDelegate) loadingDocStateServiceDelegate$delegate.getValue();
    }

    private final LoadingServiceDelegate getLoadingServiceDelegate() {
        return (LoadingServiceDelegate) loadingServiceDelegate$delegate.getValue();
    }

    private final OperationServiceDelegate getOperationServiceDelegate() {
        return (OperationServiceDelegate) operationServiceDelegate$delegate.getValue();
    }

    private static final LoadingDocStateServiceDelegate loadingDocStateServiceDelegate_delegate$lambda$2() {
        return new LoadingDocStateServiceDelegate();
    }

    private static final LoadingServiceDelegate loadingServiceDelegate_delegate$lambda$3() {
        return new LoadingServiceDelegate();
    }

    private static final OperationServiceDelegate operationServiceDelegate_delegate$lambda$4() {
        return new OperationServiceDelegate();
    }

    public final g getDocModeService() {
        return getDocModeServiceDelegate();
    }

    public final OfficeInputParam getInputParam() {
        return inputParam;
    }

    public final void addChatService(n39.c r2) {
        getChatServiceDelegate().addChatService(r2);
    }

    public final void addDocModeService(g r2) {
        getDocModeServiceDelegate().addDocModeService(r2);
    }

    public final void addLoadingDocStateService(k r2) {
        getLoadingDocStateServiceDelegate().addLoadingDocService(r2);
    }

    public final void addLoadingService(vm9.c r2) {
        getLoadingServiceDelegate().addLoadingService(r2);
    }

    public final void addOperationService(n39.d r2) {
        getOperationServiceDelegate().addOperationService(r2);
    }

    public final n39.b getChatInputFoldStatusListener(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docKey");
        return foldStatusListener.get(r2);
    }

    public final n39.c getChatService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        n39.c r3 = getChatServiceDelegate().m47getRealImpl(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return getChatServiceDelegate();
    }

    public final n39.f getDocInfoProvider(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docKey");
        return docInfoProvider.get(r2);
    }

    public final g getDocModeService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        g r3 = getDocModeServiceDelegate().m48getRealImpl(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return getDocModeServiceDelegate();
    }

    public final j getHostBizAbilityProvider(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docKey");
        return hostBizAbilityProvider.get(r2);
    }

    public final k getLoadingDocStateService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        k r3 = getLoadingDocStateServiceDelegate().m49getRealImpl(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return getLoadingDocStateServiceDelegate();
    }

    public final vm9.c getLoadingService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        vm9.c r3 = getLoadingServiceDelegate().m50getRealImpl(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return getLoadingServiceDelegate();
    }

    public final n39.d getOperationService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "docLogicKey");
        n39.d r3 = getOperationServiceDelegate().m51getRealImpl(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return getOperationServiceDelegate();
    }

    public final void removeChatService(n39.c r2) {
        getChatServiceDelegate().removeChatService(r2);
    }

    public final void removeDocModeService(g r2) {
        getDocModeServiceDelegate().removeDocModeService(r2);
    }

    public final void removeLoadingDocStateService(k r2) {
        getLoadingDocStateServiceDelegate().removeLoadingDocService(r2);
    }

    public final void removeLoadingService(vm9.c r2) {
        getLoadingServiceDelegate().removeLoadingService(r2);
    }

    public final void removeOperationService(n39.d r2) {
        getOperationServiceDelegate().removeOperationService(r2);
    }

    public final void setInputParam(OfficeInputParam r1) {
        inputParam = r1;
    }

    public final void setChatInputFoldStatusListener(n39.b r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "docKey");
        if (r2 != null) goto L6;
        foldStatusListener.remove(r3);
        return;
    L6:
        foldStatusListener.put(r3, r2);
    }

    public final void setDocInfoProvider(n39.f r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "docKey");
        if (r2 != null) goto L6;
        docInfoProvider.remove(r3);
        return;
    L6:
        docInfoProvider.put(r3, r2);
    }

    public final void setHostBizAbilityProvider(j r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "docKey");
        if (r2 != null) goto L6;
        hostBizAbilityProvider.remove(r3);
        return;
    L6:
        hostBizAbilityProvider.put(r3, r2);
    }

    public static /* synthetic */ n39.b getChatInputFoldStatusListener$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getChatInputFoldStatusListener(r1);
    }

    public static /* synthetic */ n39.c getChatService$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getChatService(r1);
    }

    public static /* synthetic */ n39.f getDocInfoProvider$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getDocInfoProvider(r1);
    }

    public static /* synthetic */ g getDocModeService$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getDocModeService(r1);
    }

    public static /* synthetic */ j getHostBizAbilityProvider$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getHostBizAbilityProvider(r1);
    }

    public static /* synthetic */ k getLoadingDocStateService$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getLoadingDocStateService(r1);
    }

    public static /* synthetic */ vm9.c getLoadingService$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getLoadingService(r1);
    }

    public static /* synthetic */ n39.d getOperationService$default(ServiceManager r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = DEFAULT_DOC_KEY;
    L6:
        return r0.getOperationService(r1);
    }

    public static /* synthetic */ void setChatInputFoldStatusListener$default(ServiceManager r0, n39.b r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = DEFAULT_DOC_KEY;
    L5:
        r0.setChatInputFoldStatusListener(r1, r2);
    }

    public static /* synthetic */ void setDocInfoProvider$default(ServiceManager r0, n39.f r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = DEFAULT_DOC_KEY;
    L5:
        r0.setDocInfoProvider(r1, r2);
    }

    public static /* synthetic */ void setHostBizAbilityProvider$default(ServiceManager r0, j r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = DEFAULT_DOC_KEY;
    L5:
        r0.setHostBizAbilityProvider(r1, r2);
    }
}
