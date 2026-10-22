package com.ss.android.lark.imageqrcode.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageQRCodeSelector {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/imageqrcode/ui/ImageQRCodeSelector$Launcher;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_PROCESS", "NON_MAIN_PATH", "NON_MAIN_BITMAP", "launch", "", "activity", "Landroid/app/Activity;", "param", "Lcom/ss/android/lark/imageqrcode/QRCodeShowParam;", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Launcher extends Enum<Launcher> {
        public static final Launcher MAIN_PROCESS = null;
        public static final Launcher NON_MAIN_BITMAP = null;
        public static final Launcher NON_MAIN_PATH = null;
        public static final /* synthetic */ Launcher[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/ss/android/lark/imageqrcode/ui/ImageQRCodeSelector.Launcher.MAIN_PROCESS", "Lcom/ss/android/lark/imageqrcode/ui/ImageQRCodeSelector$Launcher;", "launch", "", "activity", "Landroid/app/Activity;", "param", "Lcom/ss/android/lark/imageqrcode/QRCodeShowParam;", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class MAIN_PROCESS extends Launcher {
            public MAIN_PROCESS(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // com.ss.android.lark.imageqrcode.ui.ImageQRCodeSelector.Launcher
            public void launch(Activity r3, QRCodeShowParam r4) {
                Intrinsics.checkNotNullParameter(r3, "activity");
                Intrinsics.checkNotNullParameter(r4, "param");
                int r0 = ImageQRCodeSelector.a;
                ImageQRCodeSelector.b("main process");
                Intent r1 = new Intent(r3, ImageQRCodeSelectActivity.class);
                ImageQRCodeSelectActivity.d = r4;
                ImageQRCodeSelector.a(r3, r4, r1);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/ss/android/lark/imageqrcode/ui/ImageQRCodeSelector.Launcher.NON_MAIN_BITMAP", "Lcom/ss/android/lark/imageqrcode/ui/ImageQRCodeSelector$Launcher;", "launch", "", "activity", "Landroid/app/Activity;", "param", "Lcom/ss/android/lark/imageqrcode/QRCodeShowParam;", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class NON_MAIN_BITMAP extends Launcher {

            public static final class a<T> implements RxScheduledExecutor.Producer {
                public final /* synthetic */ QRCodeShowParam a;
                public final /* synthetic */ String b;

                public a(QRCodeShowParam r1, String r2) {
                    this.a = r1;
                    this.b = r2;
                }

                public final Object produce() {
                    return Boolean.valueOf(p.i(this.a.getBitmap(), this.b, Bitmap.CompressFormat.JPEG, 75));
                }
            }

            public static final class b<T> implements RxScheduledExecutor.Consumer {
                public final /* synthetic */ String a;
                public final /* synthetic */ QRCodeShowParam b;
                public final /* synthetic */ Intent c;
                public final /* synthetic */ Activity d;

                public b(String r1, QRCodeShowParam r2, Intent r3, Activity r4) {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                }

                public final void consume(Object r3) {
                    Boolean r4 = (Boolean) r3;
                    int r0 = ImageQRCodeSelector.a;
                    ImageQRCodeSelector.b("non main process, save bitmap, path:" + this.a + ", result:" + r4);
                    if (r4.booleanValue() == false) goto L6;
                    this.b.setPath(this.a);
                    this.c.putExtra("INPUT_PARAM_KEY_SHOW_PARAM", this.b);
                    ImageQRCodeSelector.a(this.d, this.b, this.c);
                    return;
                }
            }

            public NON_MAIN_BITMAP(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // com.ss.android.lark.imageqrcode.ui.ImageQRCodeSelector.Launcher
            public void launch(Activity r5, QRCodeShowParam r6) {
                Intrinsics.checkNotNullParameter(r5, "activity");
                Intrinsics.checkNotNullParameter(r6, "param");
                Intent r0 = new Intent(r5, ImageQRCodeSelectActivity.class);
                StringBuilder r1 = new StringBuilder();
                int r2 = com.suite.lark.platform.component.storage.file.dirs.e.a;
                Intrinsics.checkNotNullParameter(r5, "context");
                r1.append(com.ss.android.lark.diskmanage.storage.d.g(r5));
                r1.append(System.currentTimeMillis());
                String r3 = r1.toString();
                RxScheduledExecutor.execInIO(new a(r6, r3), new b(r3, r6, r0, r5));
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/ss/android/lark/imageqrcode/ui/ImageQRCodeSelector.Launcher.NON_MAIN_PATH", "Lcom/ss/android/lark/imageqrcode/ui/ImageQRCodeSelector$Launcher;", "launch", "", "activity", "Landroid/app/Activity;", "param", "Lcom/ss/android/lark/imageqrcode/QRCodeShowParam;", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class NON_MAIN_PATH extends Launcher {
            public NON_MAIN_PATH(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // com.ss.android.lark.imageqrcode.ui.ImageQRCodeSelector.Launcher
            public void launch(Activity r3, QRCodeShowParam r4) {
                Intrinsics.checkNotNullParameter(r3, "activity");
                Intrinsics.checkNotNullParameter(r4, "param");
                int r0 = ImageQRCodeSelector.a;
                ImageQRCodeSelector.b("non main process, use path");
                Intent r1 = new Intent(r3, ImageQRCodeSelectActivity.class);
                r1.putExtra("INPUT_PARAM_KEY_SHOW_PARAM", r4);
                ImageQRCodeSelector.a(r3, r4, r1);
            }
        }

        public Launcher() {
            throw null;
        }

        public static EnumEntries<Launcher> getEntries() {
            return b;
        }

        public abstract void launch(Activity r1, QRCodeShowParam r2);

        static {
            MAIN_PROCESS r0 = new MAIN_PROCESS("MAIN_PROCESS", 0);
            MAIN_PROCESS = r0;
            NON_MAIN_PATH r1 = new NON_MAIN_PATH("NON_MAIN_PATH", 1);
            NON_MAIN_PATH = r1;
            NON_MAIN_BITMAP r3 = new NON_MAIN_BITMAP("NON_MAIN_BITMAP", 2);
            NON_MAIN_BITMAP = r3;
            Launcher[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Launcher[] values() {
            return (Launcher[]) a.clone();
        }

        public static Launcher valueOf(String r1) {
            return (Launcher) r27.a.a(Launcher.class, r1);
        }

        public Launcher(String r1, int r2, DefaultConstructorMarker r3) {
            super(r1, r2);
        }
    }

    static {
    }

    public ImageQRCodeSelector() {
    }

    public static void b(String r1) {
        Log.i("ImageQRCodeSelector", r1);
    }

    public static final void a(Activity r1, QRCodeShowParam r2, Intent r3) {
        if (com.ss.android.lark.imageqrcode.utils.a.b(r1) == false) goto L5;
        return;
    L5:
        if (r2.isInValid() == true) goto L14;
        Integer r4 = r2.getRequestCode();
        if (r4 == null) goto L10;
        r1.startActivityForResult(r3, r4.intValue());
        return;
    L10:
        r1.startActivity(r3);
        return;
    }
}
