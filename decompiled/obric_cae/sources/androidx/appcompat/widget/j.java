package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f1191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static j f1192c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f1193a;

    public class a implements l0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f1194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f1195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f1196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f1197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f1198e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f1199f;

        public a() {
            this.f1194a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            this.f1195b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            this.f1196c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            this.f1197d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            this.f1198e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            this.f1199f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
        }

        public static boolean a(int r8, int[] r10) {
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            if (r10[r12] == r8) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public static ColorStateList b(Context r8, int r10) {
            int r11 = q0.c(r8, R.attr.colorControlHighlight);
            int r12 = q0.b(r8, R.attr.colorButtonNormal);
            return new ColorStateList(new int[][]{q0.f1249b, q0.f1251d, q0.f1250c, q0.f1253f}, new int[]{r12, a0.a.c(r11, r10), a0.a.c(r11, r10), r10});
        }

        public static LayerDrawable c(l0 r8, Context r10, int r11) {
            int r12 = r10.getResources().getDimensionPixelSize(r11);
            Drawable r13 = r8.e(r10, R.drawable.abc_star_black_48dp);
            Drawable r14 = r8.e(r10, R.drawable.abc_star_half_black_48dp);
            if ((r13 instanceof BitmapDrawable) == true) goto L5;
        L9:
            Bitmap r15 = Bitmap.createBitmap(r12, r12, Bitmap.Config.ARGB_8888);
            Canvas r16 = new Canvas(r15);
            r13.setBounds(0, 0, r12, r12);
            r13.draw(r16);
            BitmapDrawable r17 = new BitmapDrawable(r15);
            BitmapDrawable r18 = new BitmapDrawable(r15);
        L10:
            r18.setTileModeX(Shader.TileMode.REPEAT);
            if ((r14 instanceof BitmapDrawable) == true) goto L13;
        L17:
            Bitmap r19 = Bitmap.createBitmap(r12, r12, Bitmap.Config.ARGB_8888);
            Canvas r20 = new Canvas(r19);
            r14.setBounds(0, 0, r12, r12);
            r14.draw(r20);
            BitmapDrawable r21 = new BitmapDrawable(r19);
        L18:
            LayerDrawable r22 = new LayerDrawable(new Drawable[]{r17, r21, r18});
            r22.setId(0, android.R.id.background);
            r22.setId(1, android.R.id.secondaryProgress);
            r22.setId(2, android.R.id.progress);
            return r22;
        L13:
            if (r14.getIntrinsicWidth() != r12) goto L17;
            if (r14.getIntrinsicHeight() != r12) goto L17;
            r21 = (BitmapDrawable) r14;
            goto L18
        L5:
            if (r13.getIntrinsicWidth() != r12) goto L9;
            if (r13.getIntrinsicHeight() != r12) goto L9;
            r17 = (BitmapDrawable) r13;
            r18 = new BitmapDrawable(r17.getBitmap());
            goto L10
        }

        public static void e(Drawable r8, int r10, PorterDuff.Mode r11) {
            Rect r12 = d0.f1115a;
            Drawable r13 = r8.mutate();
            if (r11 != null) goto L5;
            r11 = j.f1191b;
        L5:
            r13.setColorFilter(j.c(r10, r11));
        }

        public final ColorStateList d(Context r8, int r10) {
            if (r10 != R.drawable.abc_edit_text_material) goto L7;
            return androidx.core.content.a.b(r8, R.color.abc_tint_edittext);
        L7:
            if (r10 != R.drawable.abc_switch_track_mtrl_alpha) goto L11;
            return androidx.core.content.a.b(r8, R.color.abc_tint_switch_track);
        L11:
            if (r10 != R.drawable.abc_switch_thumb_material) goto L21;
            int[][] r11 = new int[3][];
            int[] r12 = new int[3];
            ColorStateList r13 = q0.d(r8, R.attr.colorSwitchThumbNormal);
            if (r13 != null) goto L15;
        L17:
            r11[0] = q0.f1249b;
            r12[0] = q0.b(r8, R.attr.colorSwitchThumbNormal);
            r11[1] = q0.f1252e;
            r12[1] = q0.c(r8, R.attr.colorControlActivated);
            r11[2] = q0.f1253f;
            r12[2] = q0.c(r8, R.attr.colorSwitchThumbNormal);
        L19:
            return new ColorStateList(r11, r12);
        L15:
            if (r13.isStateful() == false) goto L17;
            int[] r14 = q0.f1249b;
            r11[0] = r14;
            r12[0] = r13.getColorForState(r14, 0);
            r11[1] = q0.f1252e;
            r12[1] = q0.c(r8, R.attr.colorControlActivated);
            r11[2] = q0.f1253f;
            r12[2] = r13.getDefaultColor();
            goto L19
        L21:
            if (r10 != R.drawable.abc_btn_default_mtrl_shape) goto L25;
            return b(r8, q0.c(r8, R.attr.colorButtonNormal));
        L25:
            if (r10 != R.drawable.abc_btn_borderless_material) goto L29;
            return b(r8, 0);
        L29:
            if (r10 != R.drawable.abc_btn_colored_material) goto L33;
            return b(r8, q0.c(r8, R.attr.colorAccent));
        L33:
            if (r10 == R.drawable.abc_spinner_mtrl_am_alpha) goto L56;
            if (r10 == R.drawable.abc_spinner_textfield_background_material) goto L56;
            if (a(r10, this.f1195b) == false) goto L42;
            return q0.d(r8, R.attr.colorControlNormal);
        L42:
            if (a(r10, this.f1198e) == false) goto L46;
            return androidx.core.content.a.b(r8, R.color.abc_tint_default);
        L46:
            if (a(r10, this.f1199f) == false) goto L50;
            return androidx.core.content.a.b(r8, R.color.abc_tint_btn_checkable);
        L50:
            if (r10 == R.drawable.abc_seekbar_thumb_material) goto L52;
            return null;
        L52:
            return androidx.core.content.a.b(r8, R.color.abc_tint_seek_thumb);
        L56:
            return androidx.core.content.a.b(r8, R.color.abc_tint_spinner);
        }
    }

    static {
        f1191b = PorterDuff.Mode.SRC_IN;
    }

    public static synchronized j a() {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f1192c != null) goto L7;
        d();     // Catch: Throwable -> L10
    L7:
        j r8 = f1192c;     // Catch: Throwable -> L10
        monitor-exit(j.class);
        return r8;
    }

    public static synchronized PorterDuffColorFilter c(int r8, PorterDuff.Mode r10) {
        monitor-enter(j.class);
        PorterDuffColorFilter r11 = l0.g(r8, r10);     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void d() {
        monitor-enter(j.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f1192c != null) goto L14;
        j r8 = new j();     // Catch: Throwable -> L16
        f1192c = r8;     // Catch: Throwable -> L16
        r8.f1193a = l0.c();     // Catch: Throwable -> L16
        l0 r10 = f1192c.f1193a;     // Catch: Throwable -> L16
        a r11 = new a();     // Catch: Throwable -> L16
        monitor-enter(r10);     // Catch: Throwable -> L16
        r10.f1215e = r11;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L14:
        monitor-exit(j.class);
    }

    public static void e(Drawable r8, t0 r10, int[] r11) {
        PorterDuff.Mode r12 = l0.f1208f;
        int[] r13 = r8.getState();
        Rect r14 = d0.f1115a;
        if (r8.mutate() != r8) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == true) goto L9;
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
        return;
    L9:
        if ((r8 instanceof LayerDrawable) == true) goto L11;
    L13:
        boolean r16 = r10.f1265d;
        if (r16 == false) goto L16;
    L19:
        PorterDuffColorFilter r17 = null;
        if (r16 == false) goto L22;
        ColorStateList r18 = r10.f1262a;
    L24:
        if (r10.f1264c == false) goto L26;
        PorterDuff.Mode r19 = r10.f1263b;
    L27:
        if (r18 == null) goto L31;
        if (r19 == null) goto L31;
        r17 = l0.g(r18.getColorForState(r11, 0), r19);
    L31:
        r8.setColorFilter(r17);
        return;
    L26:
        r19 = l0.f1208f;
        goto L27
    L22:
        r18 = null;
        goto L24
    L16:
        if (r10.f1264c == true) goto L19;
        r8.clearColorFilter();
        return;
    L11:
        if (r8.isStateful() == false) goto L13;
        r8.setState(new int[0]);
        r8.setState(r13);
        goto L13
    L5:
        r15 = false;
        goto L6
    }

    public final synchronized Drawable b(Context r8, int r10) {
        monitor-enter(this);
        Drawable r11 = this.f1193a.e(r8, r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }
}
