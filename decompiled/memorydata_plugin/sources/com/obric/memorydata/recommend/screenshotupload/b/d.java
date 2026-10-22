package com.obric.memorydata.recommend.screenshotupload.b;

import android.content.Context;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotInputData;
import com.obric.memorydata.recommend.screenshotupload.f;
import com.obric.memorydata.recommend.screenshotupload.j;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J2\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0016\u0010\u001e\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\f\u0010\u001f\u001a\u00020\u0006*\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/SaveViewTreePipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/Pipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "<init>", "()V", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "process", "", "input", "Lcom/obric/memorydata/recommend/screenshotupload/RequestData;", "viewTreeSource", "triggerUploadType", "Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "writeViewTreeFile", "viewTree", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "timestamp", "", AILabCheckPermissionTask.KEY_SOURCE, ObricMemoryConstants.KEY_PACKAGE_NAME, "keepDebugCopy", "", "file", "Ljava/io/File;", "serializeViewTree", "nodes", "buildViewTreeJson", "limitViewTreeField", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends com.obric.memorydata.recommend.screenshotupload.c<ScreenshotData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12551a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12552b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/SaveViewTreePipeline$Companion;", "", "<init>", "()V", "TAG", "", "VIEW_TREE_DIR_NAME", "VIEW_TREE_MAX_NODES", "", "VIEW_TREE_MAX_FIELD_LENGTH", "VIEW_TREE_MAX_BYTES", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12553a = null;

        static {
            int[] r0 = new int[TriggerUploadType.values().length];
            r0[TriggerUploadType.Action.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TriggerUploadType.ImeHide.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TriggerUploadType.AppClose.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f12553a = r0;
        }
    }

    static {
        f12551a = new a(null);
    }

    public d() {
        this.f12552b = "saveViewTree";
    }

    private final String a(TriggerUploadType r2) {
        int r1 = b.f12553a[r2.ordinal()];
        if (r1 != 1) goto L5;
        return "touch";
    L5:
        if (r1 != 2) goto L7;
        return "ime_hide";
    L7:
        if (r1 != 3) goto L13;
        return "app_close";
    L13:
        return r2.name();
    }

    private final String a(String r2) {
        if (r2.length() <= 500) goto L7;
        String r3 = r2.substring(0, 500);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        return r3;
    L7:
        return r2;
    }

    private final String a(List<ViewTreeNode> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = Math.min(r7.size(), 500);
    L3:
        if (r0 <= 0) goto L11;
        String r2 = b(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), r0));
        byte[] r3 = r2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r3, "getBytes(...)");
        if (r3.length <= 1048576) goto L10;
        if (r0 == 1) goto L10;
        r0 = r0 / 2;
    L10:
        return r2;
    L11:
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    private final String a(List<ViewTreeNode> r17, long r18, String r20, String r21) {
        List<ViewTreeNode> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Object r6 = null;
        if (j.a() == true) goto L6;
        return null;
    L6:
        if (r5 != null) goto L11;
        RunLog r3 = RunLog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("viewtree write skip source=").append(r20).append(" pkg=").append(r21);
        String r1 = " reason=no_data";
    L8:
        r3.debug("SaveViewTreePipeline", r0.append(r1).toString());
        return null;
    L11:
        if (r5.isEmpty() == false) goto L35;
        r3 = RunLog.INSTANCE;
        r0 = new StringBuilder().append("viewtree write skip source=").append(r20).append(" pkg=").append(r21);
        r1 = " reason=no_nodes";
        goto L8
    L35:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L27
        d r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        File r11 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "raw_observation_viewtree");     // Catch: Throwable -> L27
        if (r11.exists() == false) goto L16;
    L19:
        String r12 = r10.a(r5);     // Catch: Throwable -> L27
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L22;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveViewTreePipeline", "viewtree write skip source=" + r20 + " pkg=" + r21 + " reason=empty_json nodes=" + r5.size(), null, 4, null);     // Catch: Throwable -> L27
        return null;
    L22:
        if (Intrinsics.areEqual(r12, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) == true) goto L25;
        File r2 = new File(r11, r18 + '_' + UUID.randomUUID() + ".json");     // Catch: Throwable -> L27
        FilesKt.writeText$default(r2, r12, null, 2, null);     // Catch: Throwable -> L27
        r10.a(r2);     // Catch: Throwable -> L27
        RunLog.INSTANCE.debug("SaveViewTreePipeline", "viewtree saved source=" + r20 + " pkg=" + r21 + " nodes=" + r5.size() + " bytes=" + r2.length() + " view_tree_path=" + r2.getAbsolutePath());     // Catch: Throwable -> L27
        Object r4 = Result.m1421constructorimpl(r2.getAbsolutePath());     // Catch: Throwable -> L27
    L29:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r4);
        if (r13 != null) goto L32;
        r6 = r4;
    L34:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L32:
        RunLog.INSTANCE.warn("SaveViewTreePipeline", "viewtree write failed source=" + r20 + " pkg=" + r21 + " nodes=" + r5.size(), r13);
        goto L34
    L16:
        if (r11.mkdirs() == true) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveViewTreePipeline", "viewtree write skip source=" + r20 + " pkg=" + r21 + " reason=mkdir_failed", null, 4, null);     // Catch: Throwable -> L27
        return null;
    L27:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    private final void a(File r8) {
        if (AppContext.INSTANCE.isDebug() == true) goto L22;
        return;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        d r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        File r9 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "in_app_collect_debug/viewtree");     // Catch: Throwable -> L16
        if (r9.exists() == false) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L15;
        Object r10 = Result.m1421constructorimpl(FilesKt.copyTo$default(r8, new File(r9, r8.getName()), true, 0, 4, null));     // Catch: Throwable -> L16
    L18:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L23;
        RunLog.INSTANCE.error("SaveViewTreePipeline", "keep viewtree debug copy failed path=" + r8.getAbsolutePath(), r11);
        return;
    L23:
        return;
    L15:
        throw new IllegalStateException("create viewtree debug archive failed".toString());     // Catch: Throwable -> L16
    L8:
        if (r9.mkdirs() == true) goto L11;
        r0 = false;
    L16:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private final String b(List<ViewTreeNode> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        JSONArray r0 = new JSONArray();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        ViewTreeNode r2 = (ViewTreeNode) ZeusTransformUtils.preCheckCast(r9.next(), ViewTreeNode.class, "com.obric.memorydata.plugin");
        JSONObject r3 = new JSONObject();
        r3.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, a(r2.getText()));
        r3.put("desc", a(r2.getContentDescription()));
        r3.put(OaidModel.KEY_ID, a(r2.getId()));
        r3.put("cls", a(r2.getClassName()));
        JSONArray r4 = new JSONArray();
        r4.put(r2.getRect().left);
        r4.put(r2.getRect().top);
        r4.put(r2.getRect().right);
        r4.put(r2.getRect().bottom);
        Unit r5 = Unit.INSTANCE;
        r3.put("rect", r4);
        r3.put("vis", r2.getVisible());
        r0.put(r3);
        goto L4
    L6:
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.c
    public boolean a(f<ScreenshotData> r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        ScreenshotInputData r8 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r7.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getInputData();
        List<ViewTreeNode> r1 = r8.getViewTree();
        r8.setViewTree(null);
        String r6 = a(r1, r8.getTimestamp(), a(r8.getTriggerUploadType()), r8.getPackageName());
        if (r6 == null) goto L7;
        r8.setViewTreePath(r6);
        return true;
    L7:
        return true;
    }
}
