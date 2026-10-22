package ny9;

import android.os.Bundle;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.actionbar.model.j1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.message.Image;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.service.CreationDoSameNotifyInfo;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s implements t1a.c {
    public final Bundle a;
    public final HashMap<String, String> b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<lr9.a> {
        public a() {
        }
    }

    public s() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof s) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((s) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Bundle r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "InstructionArgumentData(arguments=" + this.a + ')';
    }

    public final boolean A() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("is_from_chat_double_page");
    }

    public final boolean D() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("is_reedit");
    }

    public final boolean a() {
        Bundle r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("enable_compact_fragment_forseti") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final Bundle b() {
        Bundle r0 = cy9.a.a.c(this.a);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.a;
    }

    public final Integer d() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getInt("dosame_landing_type", 0));
    }

    public final CreationDoSameNotifyInfo e() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (CreationDoSameNotifyInfo) r0.getParcelable("creation_dosame_notify_info");
    }

    public final z0 f() {
        return (z0) this.c.getValue();
    }

    public final CustomInputInitData g() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (CustomInputInitData) r0.getParcelable("custom_input_init_data");
    }

    public final String h() {
        Bundle r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getString("feed_landing_tab");
        if (r1 == null) goto L6;
        return r1;
    L6:
        z0 r2 = f();
        if (r2 == null) goto L13;
        com.larus.bmhome.actionbar.model.r r3 = r2.q;
        if (r3 == null) goto L13;
        j1 r4 = r3.e;
        if (r4 == null) goto L13;
        return r4.i;
    L13:
        return null;
    }

    public final ICoreInputAbility.MessageExtMap m() {
        Bundle r0 = this.a;
        if (r0 == null) goto L5;
        ICoreInputAbility.MessageExtMap r1 = (ICoreInputAbility.MessageExtMap) r0.getParcelable("actionbar_instruction_message_ext_map");
    L7:
        if ((r1 instanceof ICoreInputAbility.MessageExtMap) == true) goto L9;
        return null;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public final ICoreInputAbility.SendMessageTrackExtMap n() {
        Bundle r0 = this.a;
        if (r0 == null) goto L5;
        ICoreInputAbility.SendMessageTrackExtMap r1 = (ICoreInputAbility.SendMessageTrackExtMap) r0.getParcelable("actionbar_instruction_send_message_track_ext_map");
    L7:
        if ((r1 instanceof ICoreInputAbility.SendMessageTrackExtMap) == true) goto L9;
        return null;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public final String o() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("ref_image_url");
    }

    public final String p() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("ref_image_album_path");
    }

    public final String q() {
        Bundle r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString("user_prompt");
    L6:
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        if (r2.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L25;
        Bundle r4 = this.a;
        if (r4 == null) goto L16;
        TemplateInfo$TemplateInfo r5 = (TemplateInfo$TemplateInfo) r4.getParcelable("template_info");
    L18:
        if ((r5 instanceof TemplateInfo$TemplateInfo) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L24;
        r1 = r5.c;
    L24:
        return r1;
    L16:
        r5 = null;
        goto L18
    L25:
        return r2;
    L11:
        r3 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final Image r() {
        Bundle r0 = this.a;
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("reedit_ref_image");
    L7:
        if ((r1 instanceof Image) == true) goto L9;
        return null;
    L9:
        return (Image) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final String s() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("related_creation_id");
    }

    public final String t() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("related_recommendation");
    }

    public final Integer u() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getInt("select_instruction_type"));
    }

    public final String v() {
        return (String) this.k.getValue();
    }

    public final String w() {
        return (String) this.i.getValue();
    }

    public final boolean x() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("is_ai_creation");
    }

    public final boolean y() {
        Bundle r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("clear_input");
    }

    public final boolean z() {
        return ((Boolean) this.j.getValue()).booleanValue();
    }

    public final boolean B() {
        Integer r0 = l();
        if (r0 != null) goto L6;
    L7:
        if (r0 != null) goto L10;
    L11:
        if (r0 != null) goto L14;
    L16:
        return false;
    L14:
        if (r0.intValue() != 28) goto L16;
    L17:
        return true;
    L10:
        if (r0.intValue() == 16) goto L17;
    L6:
        if (r0.intValue() == 4) goto L17;
        goto L7
    }

    public final boolean C() {
        Integer r0 = l();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 28) goto L8;
        return true;
    }

    public final ChatParam c() {
        Bundle r0 = b();
        ChatParam r1 = null;
        if (r0 == null) goto L5;
        ChatParam r2 = (ChatParam) r0.getParcelable("chat_param");
    L7:
        if ((r2 instanceof ChatParam) == false) goto L9;
        r1 = r2;
    L9:
        if (r1 == null) goto L11;
        return r1;
    L11:
        return (ChatParam) this.e.getValue();
    L5:
        r2 = null;
        goto L7
    }

    public final String i() {
        Bundle r0 = b();
        if (r0 == null) goto L6;
        String r1 = r0.getString("enter_method");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "chat_action_bar";
    }

    public final boolean j() {
        Bundle r0 = b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("open_new_chat_page_on_send");
    }

    public final com.larus.bmhome.actionbar.model.r k() {
        z0 r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q;
    }

    public final Integer l() {
        com.larus.bmhome.actionbar.model.r r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public s(Bundle r1) {
        this.a = r1;
        this.b = new HashMap();
        this.c = LazyKt.lazy(new j(this));
        this.d = LazyKt.lazy(new k(this));
        this.e = LazyKt.lazy(new l(this));
        this.f = LazyKt.lazy(new m(this));
        this.g = LazyKt.lazy(new n(this));
        this.h = LazyKt.lazy(new o(this));
        this.i = LazyKt.lazy(new p(this));
        this.j = LazyKt.lazy(new q(this));
        this.k = LazyKt.lazy(new r(this));
    }
}
