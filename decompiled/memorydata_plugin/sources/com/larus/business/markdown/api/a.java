package com.larus.business.markdown.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.larus.business.markdown.api.depend.d;
import com.larus.business.markdown.api.depend.f;
import com.larus.business.markdown.api.model.e;
import com.larus.business.markdown.api.model.h;
import com.larus.business.markdown.api.model.i;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 D2\u00020\u0001:\u0001DJ\b\u0010\u0002\u001a\u00020\u0003H&JG\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0011J`\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH&JB\u0010\u0012\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH'Jx\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH'JR\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH'JN\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H'J\u0080\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0)2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010)2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\b\b\u0002\u0010/\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H'J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0013H&J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u0002042\u0006\u00105\u001a\u000206H&J\u0012\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109H&JU\u0010:\u001a\u00020\u00032K\u0010;\u001aG\u0012\u0013\u0012\u00110=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00030<H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020CH&¨\u0006E"}, d2 = {"Lcom/larus/business/markdown/api/MarkdownService;", "", "clearMarkdownDrawableCachePool", "", "createCacheMarkwonStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "context", "Landroid/content/Context;", "maxContentWidth", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "", "finished", "", "(Landroid/content/Context;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;Z)Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "createMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "markwonStructCache", "reuseCharSequence", "", "textView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "createMarkdownContentFromNode", "node", "Lorg/commonmark/node/Node;", "callBack", "Lkotlin/Function1;", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "createMarkdownNode", Params.CONTENT, "createMarkdownWidget", "isLastNode", "rootNode", "viewGroup", "Landroid/view/ViewGroup;", "lastNode", "widgetHandlerList", "", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "createMarkdownWidgets", "markdownRootNode", "lastFinishedStatus", "lastNodeList", "forceUpdateAndIgnoreNew", "formatCopyText", "markdownContent", "getNodeReportName", CommonConsts.APM_INNER_EVENT_COST_INIT, "Landroid/app/Application;", "config", "Lcom/larus/business/markdown/api/depend/IMarkdownConfig;", "registerInjectParser", "injectParser", "Lio/noties/markwon/inject/IInjectParser;", "registerLinkResolver", "resolver", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "link", "isFromWiki", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "Companion", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0213a f5138a = null;

    /* JADX INFO: renamed from: com.larus.business.markdown.api.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/larus/business/markdown/api/MarkdownService$Companion;", "", "()V", "CLASS_NAME_MARKDOWN_SERVICE_IMPL", "", "<set-?>", "Landroid/app/Application;", "application", "getApplication", "()Landroid/app/Application;", "instance", "Lcom/larus/business/markdown/api/MarkdownService;", "Lcom/larus/business/markdown/api/depend/IMarkdownEnsureManager;", "markdownEnsureManager", "getMarkdownEnsureManager", "()Lcom/larus/business/markdown/api/depend/IMarkdownEnsureManager;", "Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "markdownLogger", "getMarkdownLogger", "()Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "createService", "getService", "initContext", "", "context", "initEnsureManager", "ensureManager", "initLogger", "logger", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0213a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0213a f5139a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static a f5140b;
        private static Application c;
        private static f d;
        private static d e;

        static {
            f5139a = new C0213a();
        }

        private C0213a() {
        }

        public final Application a() {
            return c;
        }

        public final void a(Application r2) {
            Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            if (c == null) goto L5;
            return;
        L5:
            c = r1;
        }

        public final void a(f r2) {
            f r1 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "logger");
            d = r1;
        }

        public final f b() {
            return d;
        }

        public final d c() {
            return e;
        }

        public final a d() {
            a r4 = f5140b;
            a r0 = null;
            if (r4 == null) goto L8;
            if (r4 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        L26:
            return r4;
        L8:
            monitor-enter("com.larus.business.markdown.impl.MarkdownServiceImpl");
            Object r1 = ZeusTransformUtils.forName("com.larus.business.markdown.impl.MarkdownServiceImpl", "com.obric.memorydata.plugin").newInstance();     // Catch: Throwable -> L20
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.business.markdown.api.MarkdownService");     // Catch: Throwable -> L20
            a r2 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            f5140b = r2;     // Catch: Throwable -> L17
            if (r2 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("instance");     // Catch: Throwable -> L17
        L15:
            monitor-exit("com.larus.business.markdown.impl.MarkdownServiceImpl");
            return r0;
        L14:
            r0 = r2;
        L17:
            th = move-exception;
            throw th;
        L21:
            return null;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public static /* synthetic */ h a(a r12, Context r13, int r14, String r15, boolean r16, com.larus.business.markdown.api.model.c r17, e r18, CharSequence r19, Map r20, int r21, Object r22) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin");
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
            e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r18, e.class, "com.obric.memorydata.plugin");
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r19, CharSequence.class, "com.obric.memorydata.plugin");
            Map<String, ? extends Object> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
            if (r22 != null) goto L19;
            if ((r21 & 32) == 0) goto L7;
            e r9 = null;
        L9:
            if ((r21 & 64) == 0) goto L11;
            CharSequence r10 = null;
        L13:
            if ((r21 & 128) == 0) goto L15;
            Map<String, ? extends Object> r11 = null;
        L17:
            return r3.createMarkdownContent(r4, r14, r15, r16, r17, r9, r10, r11);
        L15:
            r11 = r2;
            goto L17
        L11:
            r10 = r5;
            goto L13
        L7:
            r9 = r1;
            goto L9
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownContent");
        }

        public static /* synthetic */ h a(a r13, Context r14, int r15, Node r16, boolean r17, com.larus.business.markdown.api.model.c r18, CharSequence r19, Map r20, e r21, Function1 r22, int r23, Object r24) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.memorydata.plugin");
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r19, CharSequence.class, "com.obric.memorydata.plugin");
            Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r21, e.class, "com.obric.memorydata.plugin");
            Function1<? super i, Unit> r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
            if (r24 != null) goto L23;
            if ((r23 & 32) == 0) goto L7;
            CharSequence r9 = null;
        L9:
            if ((r23 & 64) == 0) goto L11;
            Map<String, ? extends Object> r10 = null;
        L13:
            if ((r23 & 128) == 0) goto L15;
            e r11 = null;
        L17:
            if ((r23 & 256) == 0) goto L19;
            Function1<? super i, Unit> r12 = null;
        L21:
            return r3.createMarkdownContentFromNode(r4, r15, r16, r17, r18, r9, r10, r11, r12);
        L19:
            r12 = r2;
            goto L21
        L15:
            r11 = r6;
            goto L17
        L11:
            r10 = r5;
            goto L13
        L7:
            r9 = r1;
            goto L9
        L23:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownContentFromNode");
        }

        public static /* synthetic */ Node a(a r9, Context r10, String r11, boolean r12, com.larus.business.markdown.api.model.c r13, e r14, Function1 r15, int r16, Object r17) {
            a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            e r0 = (e) ZeusTransformUtils.wrapperContextForParams(r14, e.class, "com.obric.memorydata.plugin");
            Function1<? super i, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L19;
            if ((r16 & 8) == 0) goto L7;
            com.larus.business.markdown.api.model.c r6 = null;
        L9:
            if ((r16 & 16) == 0) goto L11;
            e r7 = null;
        L13:
            if ((r16 & 32) == 0) goto L15;
            Function1<? super i, Unit> r8 = null;
        L17:
            return r2.createMarkdownNode(r3, r11, r12, r6, r7, r8);
        L15:
            r8 = r1;
            goto L17
        L11:
            r7 = r0;
            goto L13
        L7:
            r6 = r13;
            goto L9
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownNode");
        }
    }

    static {
        f5138a = C0213a.f5139a;
    }

    e createCacheMarkwonStruct(Context r1, Integer r2, com.larus.business.markdown.api.model.c r3, Map<String, ? extends Object> r4, boolean r5);

    h createMarkdownContent(Context r1, int r2, String r3, boolean r4, com.larus.business.markdown.api.model.c r5, e r6, CharSequence r7, Map<String, ? extends Object> r8);

    h createMarkdownContentFromNode(Context r1, int r2, Node r3, boolean r4, com.larus.business.markdown.api.model.c r5, CharSequence r6, Map<String, ? extends Object> r7, e r8, Function1<? super i, Unit> r9);

    Node createMarkdownNode(Context r1, String r2, boolean r3, com.larus.business.markdown.api.model.c r4, e r5, Function1<? super i, Unit> r6);

    void init(Application r1, com.larus.business.markdown.api.depend.c r2);

    void registerLinkResolver(com.larus.business.markdown.api.depend.i r1);
}
