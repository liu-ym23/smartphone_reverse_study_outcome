package p82;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a {
    public View a;
    public com.bytedance.android.livesdk.interactivity.api.entity.l b;
    public com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e c;
    public final PanelItemSymbol d;

    /* JADX INFO: renamed from: p82.a$a, reason: collision with other inner class name */
    public static final class C0261a {
    }

    static {
    }

    public abstract int e();

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public void onDestroyView() {
        this.a = null;
    }

    public final String d() {
        com.bytedance.android.livesdk.interactivity.api.entity.l r0 = this.b;
        if (r0 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r1 = r0.b;
    L7:
        if ((r1 instanceof i4) == false) goto L9;
        return "reply";
    L9:
        return "create";
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final PanelItemSymbol a() {
        return this.d;
    }

    public a(PanelItemSymbol r2) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        this.d = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final View getView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (this.a != null) goto L8;
        View r4 = LayoutInflater.from(r3).inflate(e(), null);
        this.a = r4;
        if (r4 == null) goto L8;
        r4.setTag(this.d);
    L8:
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public void onClick(View r8) {
        Map r9 = MapsKt.mapOf(TuplesKt.to("event_user_type", d()));
        int r0 = com.bytedance.android.livesdk.interactivity.utils.r.a;
        long r1 = this.d.getId();
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.i r3 = r2.isAnchor();
        if (r3 == null) goto L9;
        boolean r4 = true;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L9;
    L10:
        com.bytedance.android.livesdk.interactivity.utils.r.a(r1, r4, r9);
        return;
    L9:
        r4 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public void c(com.bytedance.android.livesdk.interactivity.api.entity.l r2, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        this.b = r2;
        this.c = r3;
    }
}
