package pfb;

import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.android.lark.filedetail.impl.folder.manage.service.ExtractConfig;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends q5c.a {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static Map a(FileType r4, String r5, long r6) {
            Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
            if (r5 == null) goto L5;
            String r0 = FileUtils.m(r5);
        L6:
            if (r0 != null) goto L8;
        L10:
            String r1 = "unknown";
        L11:
            HashMap r2 = new HashMap();
            if (r4 != FileType.FOLDER) goto L14;
            r1 = "folder";
        L20:
            r2.put("file_type", r1);
            return r2;
        L14:
            if (r5 == null) goto L20;
            if (r6 == (-1)) goto L20;
            if (ExtractConfig.a(r6, r5) == false) goto L20;
            r1 = "compress_file";
            goto L20
        L8:
            if (r0.length() <= 1) goto L10;
            r1 = r0.substring(1);
            goto L11
        L5:
            r0 = null;
            goto L6
        }

        public static void b(String r2, String r3, Map r4) {
            Map<String, Object> r0 = ChatParamUtils.f(r2);
            if (r0 != null) goto L5;
            r0 = MapsKt.mapOf(TuplesKt.to("chat_id", r2));
        L5:
            JSONObject r5 = new JSONObject(r0);
            if (r4 == null) goto L11;
            Iterator r6 = r4.entrySet().iterator();
        L9:
            if (r6.hasNext() == false) goto L11;
            Map.Entry r1 = (Map.Entry) r6.next();
            r5.put((String) r1.getKey(), r1.getValue());
        L11:
            Statistics.sendEvent(r3, r5);
        }

        public static void c(String r6, String r7, Map r8) {
            Intrinsics.checkNotNullParameter(r7, "click");
            Intrinsics.checkNotNullParameter("none", "target");
            if (r6 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r5 == false) goto L11;
            return;
        L11:
            Map r9 = MapsKt.mapOf(new Pair[]{TuplesKt.to("click", r7), TuplesKt.to("target", "none"), TuplesKt.to("page_type", "folder_view")});
            if (r8 != null) goto L14;
            r8 = MapsKt.emptyMap();
        L14:
            b(r6, "im_chat_file_list_click", MapsKt.plus(r9, r8));
            return;
        L5:
            if (r6.length() == 0) goto L8;
            r5 = false;
            goto L9
        }

        public static void d(String r6, int r7, int r8) {
            if (r6 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            return;
        L11:
            Pair[] r3 = new Pair[3];
            r3[0] = TuplesKt.to("page_type", "folder_view");
            if (r7 != 1) goto L14;
            String r9 = "square";
        L15:
            r3[1] = TuplesKt.to("view_type", r9);
            if (r8 == 0) goto L27;
            if (r8 == 1) goto L27;
            if (r8 == 2) goto L27;
            if (r8 == 3) goto L27;
            if (r8 != 8) goto L23;
            String r10 = "from_search_folder";
        L28:
            r3[2] = TuplesKt.to("source", r10);
            b(r6, "im_chat_file_list_view", MapsKt.mapOf(r3));
            return;
        L23:
            if (r8 == 10) goto L25;
            r10 = "other";
            goto L28
        L25:
            r10 = "from_file_tab";
        L27:
            r10 = "from_msg_folder";
            goto L28
        L14:
            r9 = "list";
            goto L15
        L5:
            if (r6.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public static void e(String r3, String r4, String r5, Map r6) {
            Intrinsics.checkNotNullParameter(r4, "click");
            Intrinsics.checkNotNullParameter(r5, "target");
            if (r3 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            return;
        L11:
            if (r6 != null) goto L13;
            r6 = new HashMap();
        L13:
            Map r7 = MapsKt.toMutableMap(r6);
            r7.put("click", r4);
            r7.put("target", r5);
            b(r3, "im_chat_file_manage_click", r7);
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public static void f(String r3, String r4, String r5, Map r6) {
            Intrinsics.checkNotNullParameter(r4, "click");
            Intrinsics.checkNotNullParameter(r5, "target");
            if (r3 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            return;
        L11:
            Map r7 = MapsKt.toMutableMap(r6);
            r7.put("click", r4);
            r7.put("target", r5);
            b(r3, "im_chat_file_manage_more_click", r7);
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    static {
    }
}
