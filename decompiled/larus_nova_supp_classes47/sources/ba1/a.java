package ba1;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ui.GradientTextView;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.bytedance.android.livesdkapi.service.userinfo.IECLiveUserInfoAbility;
import com.bytedance.android.livesdkapi.service.userinfo.IUserInfoWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements IUserInfoWidget {
    public final View a;
    public final Context b;
    public final DataCenter c;
    public final IECLiveUserInfoAbility d;

    /* JADX INFO: renamed from: ba1.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0006a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0006a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.d.getShowAnchorProfile().invoke(null);
        }
    }

    public static final class b implements GradientTextView.a {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        public final LinearGradient a(int r9, int r10) {
            float r3 = r9;
            float r1 = r3 * 0.8947f;
            return new LinearGradient(r1, (float) ((Math.tan(Math.toRadians(32.2d)) * ((double) r9)) - ((double) r1)), r3, r10, new int[]{this.a.getContext().getResources().getColor(2131101772), this.a.getContext().getResources().getColor(2131101771)}, new float[]{0.4724f, 1.0f}, Shader.TileMode.CLAMP);
        }
    }

    public final void onEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "eventParams");
    }

    public final void onHide() {
    }

    public final void onShow() {
    }

    public final void onUnload() {
    }

    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewDetached() {
    }

    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewWillDetach() {
    }

    public final void onLoad() {
        DataCenter r0 = this.c;
        k r2 = null;
        if (r0 == null) goto L5;
        Room r1 = (Room) r0.get("data_room", null);
    L6:
        if (r1 == null) goto L10;
        User r3 = r1.getOwner();
        if (r3 == null) goto L10;
        String r4 = r3.getRealNickNameByRoomAuth(r1.getMRoomAuthStatus());
    L11:
        this.a.findViewById(2131390995).setText(r4);
        HSImageView r5 = this.a.findViewById(2131370419);
        DataCenter r6 = this.c;
        if (r6 == null) goto L14;
        Room r7 = (Room) r6.get("data_room", null);
    L15:
        o r8 = z51.a.h(this.c, 2);
        if (r8 == null) goto L22;
        n r9 = r8.getTemplateContext();
        if (r9 == null) goto L22;
        z70.b r10 = (z70.b) r9.getValue();
        if (r10 == null) goto L22;
        boolean r12 = r10.j("anchor_avatar");
    L23:
        if (r12 == false) goto L28;
        if (r7 == null) goto L32;
        RoomAvator r13 = gb2.b.c(r7);
        if (r13 == null) goto L32;
        r2 = r13.getAvatar();
    L32:
        FrescoLoader r14 = FrescoLoader.with(this.b).load(r2).placeholder(2131234546).cornersRadius(UtilityKotlinExtentionsKt.i(8)).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        int r15 = s1.f(34.0f);
        r14.resize(r15, r15);
        r14.into(r5);
        return;
    L28:
        if (r7 == null) goto L32;
        User r16 = r7.getOwner();
        if (r16 == null) goto L32;
        r2 = r16.getAvatarThumbByRoomAuth(r7.getMRoomAuthStatus());
    L22:
        r12 = false;
        goto L23
    L14:
        r7 = null;
    L10:
        r4 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final View getView() {
        return this.a;
    }

    public final View getTargetView(IUserInfoWidget.Target r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        if (ba1.b.a[r2.ordinal()] != 1) goto L7;
        return this.a.findViewById(2131372732);
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public a(Context r2, DataCenter r3, IECLiveUserInfoAbility r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "ability");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        View r5 = View.inflate(r2, 2131566974, null);
        GradientTextView r6 = r5.findViewById(2131390995);
        if (r6 == null) goto L5;
        r6.setLinearGradientCreator(new b(r5));
    L5:
        r5.setOnClickListener(new ViewOnClickListenerC0006a(this));
        Unit r7 = Unit.INSTANCE;
        this.a = r5;
    }
}
