package com.obric.assistant.obric_action;

import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.LinkedHashSet;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final String a;
    public final LinkedHashSet<String> b;

    public static final class a {
        public static final d a = null;

        static {
            d r0 = new d("activity.finish_current_page");
            r0.b.add("finish_current_page");
            a = r0;
        }
    }

    public static final class b {
        public static final b a = null;
        public static final d b = null;
        public static final d c = null;
        public static final d d = null;

        public b() {
        }

        static {
            a = new b();
            d r0 = new d("android.activity");
            r0.b.add("activity");
            b = r0;
            d r1 = new d("android.service");
            r1.b.add("service");
            c = r1;
            d r2 = new d("android.broadcast");
            r2.b.add("broadcast");
            d = r2;
        }

        public final d getActivity() {
            return b;
        }
    }

    public static final class c {
        public static final d a = null;
        public static final d b = null;
        public static final d c = null;
        public static final d d = null;
        public static final d e = null;
        public static final d f = null;

        static {
            a = new d("auth.dismiss_keyguard");
            b = new d("auth.session_auth_status");
            c = new d("auth.keyguard_status");
            d = new d("auth.request_voice_print_auth");
            e = new d("auth.request_biometric_auth");
            f = new d("auth.request_device_credential_auth");
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.obric_action.d$d, reason: collision with other inner class name */
    public static final class C0010d {
        public static final d a = null;
        public static final d b = null;
        public static final d c = null;
        public static final d d = null;
        public static final d e = null;
        public static final d f = null;
        public static final d g = null;
        public static final d h = null;

        static {
            a = new d("chat_page.open_window");
            b = new d("chat_page.pop_window");
            c = new d("chat_page.stash_window");
            d = new d("chat_page.open_new_task_panel");
            d r0 = new d("chat_page.open_clarify_input_panel");
            r0.b.add("open_clarify_input_panel");
            e = r0;
            f = new d("chat_page.open_addition_input_panel");
            g = new d("chat_page.show_keyboard");
            h = new d("chat_page.hide_keyboard");
        }
    }

    public static final class e {
        public static final d a = null;
        public static final d b = null;
        public static final d c = null;

        static {
            a = new d("feedback.toast");
            b = new d("feedback.haptic");
            c = new d("feedback.sound");
        }
    }

    public static final class f {
        public static final d a = null;
        public static final d b = null;

        static {
            d r0 = new d("message.send_message");
            r0.b.add("send_message");
            a = r0;
            d r1 = new d("message.resend_message");
            r1.b.add("resend_message");
            b = r1;
        }
    }

    public static final class g {
        public static final d a = null;
        public static final d b = null;
        public static final d c = null;
        public static final d d = null;

        static {
            d r0 = new d("omni_task.feedback");
            r0.b.add("omni_task_feed_back");
            a = r0;
            d r1 = new d("omni_task.open_create_shortcut");
            r1.b.add("open_create_shortcut");
            b = r1;
            d r2 = new d("omni_task.open_event_task_detail");
            r2.b.add("open_event_task_detail");
            c = r2;
            d = new d("omni_task.stop");
        }
    }

    public static final class h {
        public static final d a = null;
        public static final d b = null;

        static {
            a = new d("prompt.confirm_dialog");
            b = new d("prompt.options_dialog");
        }
    }

    public static final class i {
        public static final d a = null;

        static {
            d r0 = new d("router.deeplink");
            r0.b.add(MemorySourceLinkType.DEEPLINK);
            a = r0;
        }
    }

    public static final class j {
        public static final d a = null;

        static {
            d r0 = new d("server.short_link_api");
            r0.b.add("short_link_api");
            a = r0;
        }
    }

    public static final class k {
        public static final d a = null;

        static {
            d r0 = new d("settings.open_auto_gui_settings");
            r0.b.add("open_auto_gui_settings");
            a = r0;
        }
    }

    public static final class l {
        public static final d a = null;

        static {
            d r0 = new d("skill.open_skill_detail");
            r0.b.add("open_skill_detail");
            a = r0;
        }
    }

    public d(String r3) {
        this.a = r3;
        this.b = SetsKt.linkedSetOf(new String[]{r3});
    }
}
