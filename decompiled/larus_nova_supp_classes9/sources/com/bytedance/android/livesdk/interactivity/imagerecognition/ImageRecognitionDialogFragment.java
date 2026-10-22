package com.bytedance.android.livesdk.interactivity.imagerecognition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.config.n1;
import com.bytedance.android.livesdk.config.o1;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenManagerAbility;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/imagerecognition/ImageRecognitionDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageRecognitionDialogFragment extends DialogFragment {
    public static final /* synthetic */ int j = 0;
    public long d;
    public View e;
    public final b f;
    public final ImageRecognitionEntry g;
    public final String h;
    public final Function0<Unit> i;

    public static final class a {
    }

    public static final class b implements jg1.a {
        public final ClearScreenConst.InteractType a;

        public final boolean a() {
            return false;
        }

        public final boolean b() {
            return false;
        }

        public final void c() {
        }

        public final long d() {
            return 300;
        }

        public final boolean e(jg1.b.a r2) {
            Intrinsics.checkNotNullParameter(r2, "param");
            return true;
        }

        public final void f() {
        }

        public b() {
            this.a = ClearScreenConst.InteractType.IMAGE_RECOGNITION_DIALOG_SHOW;
        }

        public final ClearScreenConst.AnimType g() {
            return ClearScreenConst.AnimType.TRANS;
        }

        public final ClearScreenConst.InteractType getInteractType() {
            return this.a;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ImageRecognitionDialogFragment a;

        public c(ImageRecognitionDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            f.b("RecognitionDialog cancel button click");
            this.a.i.invoke();
        }
    }

    static {
    }

    public final void onDestroy() {
        long r0 = System.currentTimeMillis() - this.d;
        int r2 = f.a;
        f.b("ImageRecognitionDialog dismiss. showDuration=" + r0);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        jg1.b r1 = ClearScreenManagerAbility.INSTANCE.getInstance(this.h);
        if (r1 == null) goto L6;
        r1.a(this.f.a);
    L6:
        if (this.g != ImageRecognitionEntry.ClearScreen) goto L8;
        xs2.b.a().post(new ToolbarClearScreenEvent(true, ((n1) o1.a.getValue()).a()));
        return;
    L8:
        xs2.b.a().post(new ToolbarClearScreenEvent(false, ((n1) o1.a.getValue()).a()));
    }

    public final void onCreate(Bundle r4) {
        f.b("RecognitionDialog show");
        this.d = System.currentTimeMillis();
        super.onCreate(r4);
        setStyle(0, 2131954690);
        jg1.b r5 = ClearScreenManagerAbility.INSTANCE.getInstance(this.h);
        if (r5 == null) goto L5;
        r5.b(this.f);
    L5:
        xs2.b.a().post(new ToolbarClearScreenEvent(true, ((n1) o1.a.getValue()).a()));
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        setCancelable(false);
        View r4 = r2.findViewById(2131364673);
        this.e = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("buttonCancel");
    L5:
        r4.setOnClickListener(new c(this));
    }

    public ImageRecognitionDialogFragment(ImageRecognitionEntry r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        Intrinsics.checkNotNullParameter(r4, "onCancel");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.f = new b();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565490, r3, false);
    }
}
