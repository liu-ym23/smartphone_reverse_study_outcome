package com.larus.bmhome.community;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import by7.e;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Image;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.model.creation.ResourceExt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 E2\u00020\u0001:\u0001EJË\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\u00052\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010(\u001a\u00020\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H&¢\u0006\u0002\u00100Ja\u00101\u001a\u00020\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\u0010\u0010?\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001a0BH&J\n\u0010C\u001a\u0004\u0018\u00010\u000fH&J\n\u0010D\u001a\u0004\u0018\u00010\u000fH&¨\u0006F"}, d2 = {"Lcom/larus/bmhome/community/ICreationPageService;", "", "startCreationActivity", "", "isHalfScreenPage", "", "activity", "Landroid/app/Activity;", "item", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "openNewChatPageOnSend", "openNewChatPageOnSendWithClearTop", "template", "", "userPrompt", "refImageUrl", "refImage", "Lcom/larus/im/bean/message/Image;", "refCreateRefInfoList", "", "Lcom/larus/platform/model/creation/ResourceExt;", "refImageAlbumPath", "whiteIndexList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isReedit", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "extraBundle", "Landroid/os/Bundle;", "cleaInput", "msgExtMap", "", "selectStartPosition", "selectEndPosition", "isEnterTemplate", "customInputInitData", "Lcom/larus/platform/api/creation/CustomInputInitData;", "ignoreSideBar", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "compactForsetiFragment", "Landroidx/fragment/app/Fragment;", "(ZLandroid/app/Activity;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Lcom/larus/bmhome/chat/ChatParam;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;Ljava/util/List;Ljava/lang/String;Ljava/util/ArrayList;ZLcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;Lcom/ixigua/lib/track/ITrackNode;Landroid/os/Bundle;ZLjava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/platform/api/creation/CustomInputInitData;ZLcom/larus/bmhome/chat/bean/ChatPageContext;Landroidx/fragment/app/Fragment;)V", "openCreationPage", "position", "itemId", "", "instructionType", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "previousPage", "currentPage", "enterMethod", "(Ljava/lang/Integer;Landroid/app/Activity;Ljava/lang/Long;ILandroidx/lifecycle/LifecycleCoroutineScope;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "updateActionBar", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchWhiteAvatarTUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvatarCreatedStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getIpaMainUrl", "getWhiteTUrl", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationPageService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Lazy<Boolean> b = null;

        public a() {
        }

        static {
            a = new a();
            b = LazyKt.lazy(new vo8.a());
        }

        public static boolean a() {
            return ((Boolean) b.getValue()).booleanValue();
        }
    }

    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ICreationPageService r30, boolean r31, Activity r32, z0 r33, ChatParam r34, boolean r35, String r36, String r37, Image r38, List r39, ArrayList r40, boolean r41, zs8.a r42, e r43, Bundle r44, Map r45, ChatPageContext r46, Fragment r47, int r48) {
            if ((r48 & 1) == 0) goto L5;
            boolean r4 = false;
        L7:
            if ((r48 & 16) == 0) goto L9;
            boolean r8 = false;
        L11:
            if ((r48 & 64) == 0) goto L13;
            String r10 = null;
        L15:
            if ((r48 & 128) == 0) goto L17;
            String r11 = null;
        L19:
            if ((r48 & 512) == 0) goto L21;
            Image r13 = null;
        L23:
            if ((r48 & 1024) == 0) goto L25;
            List r14 = CollectionsKt.emptyList();
        L27:
            if ((r48 & 4096) == 0) goto L29;
            ArrayList r16 = new ArrayList();
        L31:
            if ((r48 & 8192) == 0) goto L33;
            boolean r17 = false;
        L35:
            if ((r48 & 16384) == 0) goto L37;
            zs8.a r18 = null;
        L39:
            if ((32768 & r48) == 0) goto L41;
            e r19 = null;
        L43:
            if ((65536 & r48) == 0) goto L45;
            Bundle r20 = null;
        L47:
            if ((262144 & r48) == 0) goto L49;
            Map r22 = null;
        L51:
            if ((2097152 & r48) == 0) goto L53;
            boolean r25 = true;
        L55:
            if ((16777216 & r48) == 0) goto L57;
            ChatPageContext r28 = null;
        L59:
            if ((r48 & 33554432) == 0) goto L61;
            Fragment r29 = null;
        L62:
            r30.a(r4, r32, r33, r34, r8, false, r10, r11, null, r13, r14, null, r16, r17, r18, r19, r20, false, r22, null, null, r25, null, false, r28, r29);
            return;
        L61:
            r29 = r47;
            goto L62
        L57:
            r28 = r46;
            goto L59
        L53:
            r25 = false;
            goto L55
        L49:
            r22 = r45;
            goto L51
        L45:
            r20 = r44;
            goto L47
        L41:
            r19 = r43;
            goto L43
        L37:
            r18 = r42;
            goto L39
        L33:
            r17 = r41;
            goto L35
        L29:
            r16 = r40;
            goto L31
        L25:
            r14 = r39;
            goto L27
        L21:
            r13 = r38;
            goto L23
        L17:
            r11 = r37;
            goto L19
        L13:
            r10 = r36;
            goto L15
        L9:
            r8 = r35;
            goto L11
        L5:
            r4 = r31;
            goto L7
        }
    }

    static {
        a = a.a;
    }

    void a(boolean r1, Activity r2, z0 r3, ChatParam r4, boolean r5, boolean r6, String r7, String r8, String r9, Image r10, List<ResourceExt> r11, String r12, ArrayList<Integer> r13, boolean r14, zs8.a r15, e r16, Bundle r17, boolean r18, Map<String, String> r19, Integer r20, Integer r21, boolean r22, CustomInputInitData r23, boolean r24, ChatPageContext r25, Fragment r26);

    void b(GlobalScope r1);

    Object c(Continuation<? super String> r1);

    String d();

    StateFlowImpl e();

    void f(Integer r1, FragmentActivity r2, Long r3, int r4, LifecycleCoroutineScope r5, String r6, String r7, String r8);

    String g();
}
