package dgb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chatwindow.launcher.c;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.create.groupchat.impl.service.h;
import com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.EntryPointAccessors;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a {
    public static final /* synthetic */ int d = 0;

    @Inject
    public h a;

    @Inject
    public c b;

    @Inject
    public hab.b c;

    /* JADX INFO: renamed from: dgb.a$a, reason: collision with other inner class name */
    public static final class C0248a {
        public static a a() {
            return ((b) EntryPointAccessors.fromApplication(LarkContext.getApplication(), b.class)).d();
        }
    }

    static {
    }

    @Inject
    public a() {
    }

    public static void a(FragmentActivity r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intent r0 = new Intent(r4, FlowGroupCreateActivity.class);
        PassportcConvention.e(r0, LarkContext.getApplication());
        Bundle r1 = new Bundle();
        r1.putString("key_group_create_scene", "group_create_scene_p2p_chat");
        r1.putString("key_group_create_chat_id", r5);
        r0.putExtras(r1);
        r4.startActivity(r0);
        Log.d("FlowCreateGroupChatModule", "createGroupFromP2PChat");
    }

    public final void b(Context r12, GroupCreateInfo r13, List<? extends SearchBaseInfo> r14, IGetDataCallback<Chat> r15, CreateGroupScene r16, IGetDataCallback<w5b.a> r17, Fragment r18) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "groupCreateInfo");
        Intrinsics.checkNotNullParameter(r14, "searchInfos");
        Intrinsics.checkNotNullParameter(r16, "source");
        h r1 = this.a;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("createGroupService");
        r1 = null;
    L6:
        hab.b r6 = this.c;
        if (r6 == null) goto L9;
        hab.b r10 = r6;
    L10:
        r1.Da(r12, r13, r14, r15, r16, r17, r18, r10);
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("chatDependency");
        r10 = null;
        goto L10
    }
}
