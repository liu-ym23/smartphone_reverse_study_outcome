package ofb;

import com.bytedance.lark.pb.basic.v1.FilePreviewStage;
import com.bytedance.lark.pb.media.v1.BrowseFolderRequest;
import com.bytedance.lark.pb.media.v1.BrowseFolderResponse;
import com.bytedance.lark.pb.media.v1.DownloadFileOptions;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static BrowseFolderRequest.Builder a(nfb.b r5) {
        BrowseFolderRequest.SerReq r0 = new BrowseFolderRequest.SerReq.Builder().key(r5.a).start(Long.valueOf(r5.b)).step(Long.valueOf(r5.c)).order_type(BrowseFolderRequest.SerReq.IndexKey.fromValue(r5.d)).order_direction(BrowseFolderRequest.SerReq.Direction.fromValue(r5.e)).build();
        String r1 = r5.g;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L19;
        String r4 = r5.i;
        if (r4 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        DownloadFileOptions r7 = null;
    L47:
        return new BrowseFolderRequest.Builder().ser_req(r0).scene(DownloadFileScene.fromValue(r5.f)).options(r7);
    L13:
        if (r4.length() == 0) goto L16;
        r6 = false;
    L19:
        DownloadFileOptions.Builder r8 = new DownloadFileOptions.Builder();
        String r9 = r5.g;
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == true) goto L28;
        r8.preview_token(r5.g);
    L28:
        String r11 = r5.h;
        if (r11 != null) goto L31;
    L34:
        boolean r12 = true;
    L35:
        if (r12 == true) goto L37;
        r8.auth_file_key(r5.h);
    L37:
        String r13 = r5.i;
        if (r13 != null) goto L40;
    L43:
        if (r2 == true) goto L45;
        r8.msg_link_token(r5.i);
    L45:
        r7 = r8.build();
        goto L47
    L40:
        if (r13.length() == 0) goto L43;
        r2 = false;
        goto L43
    L31:
        if (r11.length() == 0) goto L34;
        r12 = false;
        goto L35
    L22:
        if (r9.length() == 0) goto L25;
        r10 = false;
        goto L26
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public static nfb.c b(BrowseFolderResponse r14, String r15) {
        if (r14 == null) goto L61;
        List r0 = r14.ser_resp.infos;
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L68;
        List r2 = r14.ser_resp.infos;
        Map r3 = r14.key2path;
        ArrayList r4 = new ArrayList();
        Intrinsics.checkNotNull(r2);
        Iterator r5 = r2.iterator();
    L14:
        if (r5.hasNext() == false) goto L59;
        BrowseFolderResponse.SerResp.BrowseInfo r6 = (BrowseFolderResponse.SerResp.BrowseInfo) r5.next();
        String r7 = r6.key;
        if (r3 == null) goto L19;
        String r8 = (String) r3.get(r7);
        if (r8 == null) goto L19;
    L20:
        Intrinsics.checkNotNull(r6);
        String r9 = r6.key;
        nfb.a.C0266a r10 = new nfb.a.C0266a();
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNullParameter(r9, "key");
        r10.a = r9;
        String r11 = r6.name;
        Intrinsics.checkNotNullParameter(r11, IPortraitService.NAME);
        r10.c = r11;
        FileType.a r12 = FileType.Companion;
        int r13 = r6.type.getValue();
        r12.getClass();
        FileType[] r16 = FileType.values();
        int r17 = r16.length;
        int r18 = 0;
    L21:
        if (r18 >= r17) goto L26;
        FileType r19 = r16[r18];
        if (r19.getNumber() == r13) goto L27;
        r18 = r18 + 1;
    L27:
        Intrinsics.checkNotNullParameter(r19, IPortraitService.TYPE);
        r10.b = r19;
        r10.d = r6.size.longValue();
        r10.e = r6.create_time.longValue();
        r10.f = r6.owner_id.longValue();
        r10.i = r6.preview_image_key;
        FilePreviewStage r20 = r6.preview_stage;
        if (r20 == null) goto L43;
        com.ss.android.lark.chat.entity.message.content.FilePreviewStage.a r21 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.Companion;
        int r22 = r20.getValue();
        r21.getClass();
        if (r22 != 1) goto L32;
        com.ss.android.lark.chat.entity.message.content.FilePreviewStage r23 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.Normal;
    L42:
        Intrinsics.checkNotNullParameter(r23, "filePreviewStage");
        r10.j = r23;
        goto L43
    L32:
        if (r22 != 2) goto L34;
        r23 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.Encrypted;
        goto L42
    L34:
        if (r22 != 3) goto L36;
        r23 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.NotSupportedType;
        goto L42
    L36:
        if (r22 == 4) goto L38;
        r23 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.UnknownStage;
        goto L42
    L38:
        r23 = com.ss.android.lark.chat.entity.message.content.FilePreviewStage.NotSupportedSize;
    L43:
        String r24 = r6.owner_name;
        if (r24 != null) goto L46;
    L49:
        boolean r25 = true;
    L50:
        if (r25 == true) goto L53;
        String r26 = r6.owner_name;
        Intrinsics.checkNotNullParameter(r26, "ownerName");
        r10.g = r26;
    L53:
        if (r8.length() != 0) goto L55;
        boolean r27 = true;
    L56:
        if (r27 == true) goto L58;
        Intrinsics.checkNotNullParameter(r8, "path");
        r10.h = r8;
    L58:
        nfb.a r28 = r10.a();
        r28.l = r15;
        r4.add(r28);
        goto L14
    L55:
        r27 = false;
        goto L56
    L46:
        if (r24.length() == 0) goto L49;
        r25 = false;
        goto L50
    L26:
        r19 = FileType.UNKNOWN;
    L19:
        r8 = BuildConfig.FLAVOR;
        goto L20
    L59:
        nfb.c r110 = new nfb.c();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r110.a = r4;
        r110.b = r14.ser_resp.all_count.longValue();
        r110.c = r14.ser_resp.has_more.booleanValue();
        return r110;
    L68:
        return null;
    L6:
        if (r0.isEmpty() == true) goto L9;
        r1 = false;
        goto L10
    L61:
        return null;
    }
}
