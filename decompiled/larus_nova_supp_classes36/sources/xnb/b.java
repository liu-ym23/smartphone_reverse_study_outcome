package xnb;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.model.dispatch.PreprocessParams;
import com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor;
import com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessorV2;
import com.ss.android.lark.chat.base.model.dispatch.ResourceType;
import com.ss.android.lark.chat.base.model.dispatch.f;
import com.ss.android.lark.chat.base.model.dispatch.g;
import com.ss.android.lark.chat.base.model.dispatch.i;
import com.ss.android.lark.chat.base.model.dispatch.o;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection;
import com.ss.android.lark.widget.photopicker.e;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.j;
import io.reactivex.Observable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.keyboard.plugin.tool.photo.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ c b;
    public final /* synthetic */ boolean c;

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void a() {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final boolean j() {
        return true;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void n() {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final boolean p() {
        return true;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void l() {
        int r0 = o.a;
        ResourcePreprocessorV2 r1 = ResourcePreprocessorV2.a;
        Log.i("ResourcePreprocessorV2", "cancelAllPreUpload");
        i.a();
        r1.d().removeCallbacksAndMessages(null);
        ((CopyOnWriteArraySet) ResourcePreprocessorV2.c).clear();
        Map r2 = ResourcePreprocessorV2.b;
        monitor-enter(r2);
        ArrayList r3 = new ArrayList(r2.size());     // Catch: Throwable -> L15
        Iterator r4 = r2.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add((g) ((Map.Entry) r4.next()).getValue());     // Catch: Throwable -> L15
        goto L6
    L9:
        monitor-exit(r2);
        ResourcePreprocessorV2.b.clear();
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        g r6 = (g) r5.next();
        ResourcePreprocessorV2 r7 = ResourcePreprocessorV2.a;
        ResourcePreprocessorV2.a(r6);
        goto L12
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void d(j r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.b(this.a, this.b.b.a);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final boolean f(boolean r8) {
        int r0 = o.a;
        f r1 = f.f;
        f r2 = new f(false, true, false, this.c, r8);
        Intrinsics.checkNotNullParameter(r2, "params");
        ResourcePreprocessorV2 r9 = ResourcePreprocessorV2.a;
        return ResourcePreprocessorV2.c(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void g(int r15) {
        int r0 = o.a;
        ResourcePreprocessorV2.a.d().removeCallbacksAndMessages(null);
        ((CopyOnWriteArraySet) ResourcePreprocessorV2.c).clear();
        int r1 = i.c;
        long r2 = System.currentTimeMillis();
        long r4 = r2 - i.a;
        long r3 = r2 - i.b;
        int r6 = i.h;
        if (r6 <= 0) goto L5;
        double r9 = i.g / ((double) r6);
    L6:
        if (r15 > 0) goto L8;
    L23:
        i.a();
        return;
    L8:
        if (r4 <= 0) goto L23;
        if (r3 <= 0) goto L23;
        if (r9 < 0.0d) goto L23;
        if (r6 < 0) goto L23;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L17
        r7.put("first_select_to_send_interval", r4);     // Catch: Throwable -> L17
        r7.put("last_select_to_send_interval", r3);     // Catch: Throwable -> L17
        r7.put("pre_process_resource_count", i.c);     // Catch: Throwable -> L17
        r7.put("resource_count", r15);     // Catch: Throwable -> L17
        r7.put("repeat_select_cost", r9);     // Catch: Throwable -> L17
        r7.put("repeat_select_count", i.h);     // Catch: Throwable -> L17
        Log.i("PreprocessHitPointUtil", "sendAndReset / Send event: resource_select_dev");     // Catch: Throwable -> L17
        Statistics.sendEvent("resource_select_dev", r7);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Log.e("PreprocessHitPointUtil", "sendAndReset / " + th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        i.a();
        throw th;
    L5:
        r9 = 0.0d;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void h(ArrayList<File> r2) {
        Intrinsics.checkNotNullParameter(r2, "fileList");
        KeyboardViewModel r0 = j2b.d.a(this.b.b);
        if (r0 == null) goto L6;
        r0.sendFileMsg(r2);
        return;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void m(e r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        r4.b(this.a, this.b.b.a, 233);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final Observable<Map<String, FrameInfo>> o(List<VideoInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "videoInfos");
        return ChatAppContainerV1.a.W().Db(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void i(List<Photo> r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "videoPaths");
        com.ss.android.lark.biz.im.api.extension.chat_window.b r0 = this.b.b;
        com.ss.android.lark.keyboard.b r1 = r0.b;
        if (r1 == null) goto L8;
        KeyboardViewModel r2 = j2b.d.a(r0);
        if (r2 == null) goto L9;
        r2.sendMediaMsg(r9, com.ss.android.lark.keyboard.a.d(r1), com.ss.android.lark.keyboard.a.b(r1), r10, ReplyActionUtils.e(com.ss.android.lark.keyboard.a.c(r1)));
        return;
    L9:
        return;
    }

    public b(Context r1, c r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final Observable b(List r8, boolean r9, CommentKeyboardSection.handleActivityResult.1 r10) {
        Intrinsics.checkNotNullParameter(r8, "photos");
        return ChatAppContainerV1.a.W().M4(r8, r9, r10, Biz.Messenger, Scene.Chat).map(a.a);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void c(List<? extends Photo> r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "selectedPhotos");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r0.add(q((Photo) r12.next(), r10, r11));
        goto L4
    L6:
        int r13 = o.a;
        Intrinsics.checkNotNullParameter(r0, "paramsList");
        ImSdkProxy.d().isFirstOpenAlbum();
        ResourcePreprocessorV2 r14 = ResourcePreprocessorV2.a;
        ArrayList r15 = new ArrayList();
        Iterator r1 = r0.iterator();
    L7:
        boolean r2 = true;
        boolean r3 = false;
        ResourceType r4 = null;
        if (r1.hasNext() == false) goto L18;
        Object r5 = r1.next();
        PreprocessParams r6 = (PreprocessParams) r5;
        if (r6 == null) goto L13;
        r4 = r6.getType();
    L13:
        if (r4 == ResourceType.IMAGE) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L7;
        r15.add(r5);
        goto L7
    L18:
        Intrinsics.checkNotNullParameter(r15, "paramsList");
        if (i.e == false) goto L21;
        Log.i("PreprocessHitPointUtil", "onToggleOrigin / Repeat toggle origin");
        boolean r16 = true;
    L22:
        i.b(r16);
        i.e = true;
        StringBuilder r17 = new StringBuilder("preprocessOnToggleOrigin / Get resources: [");
        Iterator r18 = r15.iterator();
        f r7 = null;
    L24:
        if (r18.hasNext() == false) goto L32;
        com.ss.android.lark.chat.base.model.dispatch.d r8 = (PreprocessParams) r18.next();
        if ((r8 instanceof com.ss.android.lark.chat.base.model.dispatch.d) == false) goto L28;
        com.ss.android.lark.chat.base.model.dispatch.d r19 = r8;
    L29:
        if (r19 == null) goto L31;
        boolean r20 = r19.e;
        f r21 = ((PreprocessParams) r19).b;
        r17.append("{ " + r19.getType() + ", " + ((String) ((PreprocessParams) r19).c.getValue()) + " }, ");
        r3 = r20;
        r7 = r21;
    L31:
        r14.f(r8, ResourcePreprocessorV2.Action.TOGGLE_ORIGIN);
        goto L24
    L28:
        r19 = null;
        goto L29
    L32:
        r17.append("], origin: " + r3 + ", preUploadParams: " + r7);
        Log.i("ResourcePreprocessorV2", r17.toString());
        return;
    L21:
        r16 = false;
        goto L22
    }

    public final PreprocessParams q(Photo r8, boolean r9, boolean r10) {
        PreprocessParams.a r0 = new PreprocessParams.a();
        if (r8.isVideo() == false) goto L5;
        ResourceType r1 = ResourceType.MEDIA;
    L6:
        Intrinsics.checkNotNullParameter(r1, "type");
        r0.a = r1;
        r0.b = r8.getPath();
        r0.c = r9;
        f r11 = f.f;
        f r12 = new f(false, true, false, this.c, r10);
        Intrinsics.checkNotNullParameter(r12, "preUploadParams");
        ResourceType r13 = r0.a;
        if (r13 != null) goto L10;
        Log.e("PreprocessParams", "createParams / FileType is null");
    L14:
        return null;
    L10:
        if (PreprocessParams.a.a.a[r13.ordinal()] != 1) goto L12;
        com.ss.android.lark.chat.base.model.dispatch.c r14 = new com.ss.android.lark.chat.base.model.dispatch.c(r13, r0.b, r12);
    L17:
        return r14;
    L12:
        String r2 = r0.b;
        if (r2 == null) goto L14;
        r14 = new com.ss.android.lark.chat.base.model.dispatch.d(r13, r2, r0.c, r12);
        goto L17
    L5:
        r1 = ResourceType.IMAGE;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void e(ArrayList<String> r11, boolean r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "photoPaths");
        com.ss.android.lark.biz.im.api.extension.chat_window.b r0 = this.b.b;
        com.ss.android.lark.keyboard.b r1 = r0.b;
        if (r1 == null) goto L8;
        KeyboardViewModel r2 = j2b.d.a(r0);
        if (r2 == null) goto L9;
        r2.sendImageMsg(r11, r12, com.ss.android.lark.keyboard.a.d(r1), com.ss.android.lark.keyboard.a.b(r1), r13, r14, ReplyActionUtils.e(com.ss.android.lark.keyboard.a.c(r1)));
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.a
    public final void k(Photo r8, boolean r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "photo");
        int r0 = o.a;
        com.ss.android.lark.chat.base.model.dispatch.c r12 = q(r8, r10, r11);
        if (r9 == false) goto L5;
        ResourcePreprocessorV2.Action r13 = ResourcePreprocessorV2.Action.CHECK;
    L6:
        Intrinsics.checkNotNullParameter(r13, "action");
        if (r12 == null) goto L38;
        ImSdkProxy.d().isFirstOpenAlbum();
        if (r12.getType() != ResourceType.IMAGE) goto L13;
        ResourcePreprocessorV2.a.f(r12, r13);
        return;
    L13:
        if (r13 == ResourcePreprocessorV2.Action.TOGGLE_ORIGIN) goto L39;
        ResourceType r14 = r12.getType();
        int r15 = o.a.a[r14.ordinal()];
        com.ss.android.lark.chat.base.model.dispatch.c r1 = null;
        if (r15 == 1) goto L29;
        if (r15 == 2) goto L29;
        if (r15 != 3) goto L27;
        if ((r12 instanceof com.ss.android.lark.chat.base.model.dispatch.c) == false) goto L24;
        r1 = r12;
    L24:
        if (r1 == null) goto L35;
        ResourcePreprocessor r16 = ResourcePreprocessor.c.a;
        ResourcePreprocessor.FileType r17 = ResourcePreprocessor.FileType.FILE;
        ResourcePreprocessor.FileType r2 = ResourcePreprocessor.FileType.fromValue(r1.getType().getValue());
        String r3 = r1.d;
        Uri r4 = r1.e;
        boolean r18 = ((PreprocessParams) r1).b.d;
        r16.d(new ResourcePreprocessor.d(r2, r3, r4, r13.toBoolean(), true));
        return;
    L35:
        return;
    L27:
        throw new NoWhenBranchMatchedException();
    L29:
        if ((r12 instanceof com.ss.android.lark.chat.base.model.dispatch.d) == false) goto L31;
        r1 = (com.ss.android.lark.chat.base.model.dispatch.d) r12;
    L31:
        if (r1 == null) goto L37;
        ResourcePreprocessor r19 = ResourcePreprocessor.c.a;
        ResourcePreprocessor.FileType r110 = ResourcePreprocessor.FileType.FILE;
        ResourcePreprocessor.FileType r5 = ResourcePreprocessor.FileType.fromValue(r1.getType().getValue());
        String r6 = ((com.ss.android.lark.chat.base.model.dispatch.d) r1).d;
        boolean r7 = ((com.ss.android.lark.chat.base.model.dispatch.d) r1).e;
        boolean r111 = ((PreprocessParams) r1).b.d;
        r19.d(new ResourcePreprocessor.d(r5, r6, null, r13.toBoolean(), r7));
        return;
    L37:
        return;
    L39:
        return;
    L38:
        return;
    L5:
        r13 = ResourcePreprocessorV2.Action.UNCHECK;
        goto L6
    }
}
