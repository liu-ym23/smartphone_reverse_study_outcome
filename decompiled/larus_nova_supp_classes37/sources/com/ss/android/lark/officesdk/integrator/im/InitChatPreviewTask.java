package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010\f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/im/InitChatPreviewTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "initialize", "observeActivityLifecycle", "getImApi", "Lcom/ss/android/lark/biz/im/api/IIMApi;", "notifyImApiUnavailable", "T", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Companion", "FlowColorKeyResMapper", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InitChatPreviewTask extends AbstractLaunchTask<InitChatPreviewTask> {
    public static final Object c = null;
    public static volatile boolean d;

    public static final class a {
    }

    public static final class b implements ycb.a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Integer a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            int r0 = r2.hashCode();
            switch(r0) {
                case -2068859131: goto L243;
                case -2009728445: goto L239;
                case -1672317085: goto L235;
                case -1669546491: goto L231;
                case -1439227059: goto L227;
                case -1371313588: goto L223;
                case -1333542996: goto L219;
                case -1327765469: goto L215;
                case -1327765407: goto L211;
                case -1327765345: goto L207;
                case -1274951098: goto L203;
                case -1274951067: goto L199;
                case -1274951036: goto L195;
                case -1274951005: goto L191;
                case -1260421165: goto L187;
                case -975128085: goto L183;
                case -882332352: goto L179;
                case -804986403: goto L175;
                case -227418847: goto L171;
                case -202273982: goto L167;
                case -164668864: goto L163;
                case -164254884: goto L159;
                case -153802045: goto L155;
                case -113611934: goto L151;
                case 235562976: goto L147;
                case 254845962: goto L143;
                case 331212617: goto L139;
                case 865558735: goto L135;
                case 1044147860: goto L131;
                case 1076056098: goto L127;
                case 1169193754: goto L123;
                case 1236655333: goto L119;
                case 1258041427: goto L115;
                case 1286481939: goto L111;
                case 1318759642: goto L107;
                case 1605180481: goto L103;
                case 1610529979: goto L99;
                case 1788941547: goto L95;
                case 1811239934: goto L91;
                default: goto L4;
            };
        L4:
            switch(r0) {
                case -2029284675: goto L87;
                case -2029284674: goto L83;
                case -2029284673: goto L79;
                case -2029284672: goto L75;
                case -2029284671: goto L71;
                case -2029284670: goto L67;
                default: goto L5;
            };
        L5:
            switch(r0) {
                case -1585595152: goto L63;
                case -1585595151: goto L59;
                case -1585595150: goto L55;
                case -1585595149: goto L51;
                default: goto L6;
            };
        L6:
            switch(r0) {
                case -1451611669: goto L47;
                case -1451611668: goto L43;
                case -1451611667: goto L39;
                case -1451611666: goto L35;
                default: goto L7;
            };
        L7:
            switch(r0) {
                case 1162514931: goto L31;
                case 1162514932: goto L27;
                case 1162514933: goto L23;
                case 1162514934: goto L19;
                default: goto L8;
            };
        L8:
            switch(r0) {
                case 1584624080: goto L15;
                case 1584624081: goto L11;
                default: goto L244;
            };
        L244:
            return null;
        L11:
            if (r2.equals("additional-red-festival-transpant-2") == false) goto L244;
            return 2131102017;
        L15:
            if (r2.equals("additional-red-festival-transpant-1") == false) goto L244;
            return 2131102016;
        L19:
            if (r2.equals("static-white-transparent-4") == false) goto L244;
            return 2131102067;
        L23:
            if (r2.equals("static-white-transparent-3") == false) goto L244;
            return 2131102066;
        L27:
            if (r2.equals("static-white-transparent-2") == false) goto L244;
            return 2131102065;
        L31:
            if (r2.equals("static-white-transparent-1") == false) goto L244;
            return 2131102064;
        L35:
            if (r2.equals("primary-transparent-4") == false) goto L244;
            return 2131102059;
        L39:
            if (r2.equals("primary-transparent-3") == false) goto L244;
            return 2131102058;
        L43:
            if (r2.equals("primary-transparent-2") == false) goto L244;
            return 2131102057;
        L47:
            if (r2.equals("primary-transparent-1") == false) goto L244;
            return 2131102055;
        L51:
            if (r2.equals("neutral-transparent-4") == false) goto L244;
            return 2131102048;
        L55:
            if (r2.equals("neutral-transparent-3") == false) goto L244;
            return 2131102047;
        L59:
            if (r2.equals("neutral-transparent-2") == false) goto L244;
            return 2131102046;
        L63:
            if (r2.equals("neutral-transparent-1") == false) goto L244;
            return 2131102045;
        L67:
            if (r2.equals("bg-base-6") == false) goto L244;
            return 2131102033;
        L71:
            if (r2.equals("bg-base-5") == false) goto L244;
            return 2131102032;
        L75:
            if (r2.equals("bg-base-4") == false) goto L244;
            return 2131102030;
        L79:
            if (r2.equals("bg-base-3") == false) goto L244;
            return 2131102028;
        L83:
            if (r2.equals("bg-base-2") == false) goto L244;
            return 2131102025;
        L87:
            if (r2.equals("bg-base-1") == false) goto L244;
            return 2131102022;
        L91:
            if (r2.equals("conditional-danger-50") == false) goto L244;
            return 2131102036;
        L95:
            if (r2.equals("neutral-100") == false) goto L244;
            return 2131102040;
        L99:
            if (r2.equals("bg-press") == false) goto L244;
            return 2131102035;
        L103:
            if (r2.equals("bg-base-2-overlay") == false) goto L244;
            return 2131102026;
        L107:
            if (r2.equals("additional-yellow") == false) goto L244;
            return 2131102020;
        L111:
            if (r2.equals("conditional-warning-50") == false) goto L244;
            return 2131102039;
        L115:
            if (r2.equals("additional-wathet") == false) goto L244;
            return 2131102019;
        L119:
            if (r2.equals("additional-violet") == false) goto L244;
            return 2131102018;
        L123:
            if (r2.equals("additional-red-festival") == false) goto L244;
            return 2131102015;
        L127:
            if (r2.equals("additional-purple") == false) goto L244;
            return 2131102011;
        L131:
            if (r2.equals("additional-orange") == false) goto L244;
            return 2131102009;
        L135:
            if (r2.equals("primary-transparent-1-1") == false) goto L244;
            return 2131102056;
        L139:
            if (r2.equals("static-black-transparent-1") == false) goto L244;
            return 2131102061;
        L143:
            if (r2.equals("static-white") == false) goto L244;
            return 2131102063;
        L147:
            if (r2.equals("static-black") == false) goto L244;
            return 2131102060;
        L151:
            if (r2.equals("additional-purple-premium-transpant-1") == false) goto L244;
            return 2131102013;
        L155:
            if (r2.equals("neutral-80-transparent") == false) goto L244;
            return 2131102044;
        L159:
            if (r2.equals("additional-pink") == false) goto L244;
            return 2131102010;
        L163:
            if (r2.equals("additional-blue") == false) goto L244;
            return 2131102007;
        L167:
            if (r2.equals("bg-base-3-overlay") == false) goto L244;
            return 2131102029;
        L171:
            if (r2.equals("bg-base-1-1") == false) goto L244;
            return 2131102023;
        L175:
            if (r2.equals("additional-green") == false) goto L244;
            return 2131102008;
        L179:
            if (r2.equals("bg-base-1-overlay") == false) goto L244;
            return 2131102024;
        L183:
            if (r2.equals("additional-red") == false) goto L244;
            return 2131102014;
        L187:
            if (r2.equals("conditional-info-50") == false) goto L244;
            return 2131102037;
        L191:
            if (r2.equals("primary-80") == false) goto L244;
            return 2131102053;
        L195:
            if (r2.equals("primary-70") == false) goto L244;
            return 2131102052;
        L199:
            if (r2.equals("primary-60") == false) goto L244;
            return 2131102051;
        L203:
            if (r2.equals("primary-50") == false) goto L244;
            return 2131102049;
        L207:
            if (r2.equals("neutral-70") == false) goto L244;
            return 2131102043;
        L211:
            if (r2.equals("neutral-50") == false) goto L244;
            return 2131102042;
        L215:
            if (r2.equals("neutral-30") == false) goto L244;
            return 2131102041;
        L219:
            if (r2.equals("additional-purple-premium") == false) goto L244;
            return 2131102012;
        L223:
            if (r2.equals("conditional-success-50") == false) goto L244;
            return 2131102038;
        L227:
            if (r2.equals("additional-yellow-bright") == false) goto L244;
            return 2131102021;
        L231:
            if (r2.equals("primary-80-50") == false) goto L244;
            return 2131102054;
        L235:
            if (r2.equals("primary-50-40") == false) goto L244;
            return 2131102050;
        L239:
            if (r2.equals("bg-base-4-overlay") == false) goto L244;
            return 2131102031;
        L243:
            if (r2.equals("static-primary-50") == false) goto L244;
            return 2131102062;
        }
    }

    static {
        c = new Object();
    }

    public InitChatPreviewTask() {
    }

    public static final IIMApi j(InitChatPreviewTask r0) {
        r0.getClass();
        return (IIMApi) ApiUtils.getApi(IIMApi.class);
    }

    public final void a(Context r4) {
        Object r0 = c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (d == false) goto L9;
        Log.i("[URLPreview]InitChatPreviewTask", "skip duplicated initialization");     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L9:
        g r2 = new g(this, r4, new h());     // Catch: Throwable -> L12
        g6b.a.a = r2;     // Catch: Throwable -> L12
        i6b.a r5 = i6b.b.a;     // Catch: Throwable -> L12
        i6b.b.a = r2;     // Catch: Throwable -> L12
        LarkContext.getApplication().registerActivityLifecycleCallbacks(new j());     // Catch: Throwable -> L12
        d = true;     // Catch: Throwable -> L12
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    }
}
