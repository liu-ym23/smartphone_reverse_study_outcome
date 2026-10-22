package com.obric.oui.segmentedtab;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.c.i;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.k;
import com.obric.oui.common.style.m;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.h;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 î\u00012\u00020\u00012\u00020\u0002:\nî\u0001ï\u0001ð\u0001ñ\u0001ò\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010\u0096\u0001\u001a\u00020\u0016H\u0003J\u0013\u0010\u0097\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0098\u0001\u001a\u00020$H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u0094\u0001H\u0002J\u0013\u0010\u009a\u0001\u001a\u00020$2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\u0013\u0010\u009d\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u009e\u0001\u001a\u00020$H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020\b2\u0007\u0010 \u0001\u001a\u00020\u001bH\u0002J\u001d\u0010¡\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010¤\u0001\u001a\u00020\u001bH\u0002J\u0014\u0010¥\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\u0014\u0010¦\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\u001d\u0010§\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010¤\u0001\u001a\u00020\u001bH\u0002J\t\u0010¨\u0001\u001a\u0004\u0018\u00010TJ\u0011\u0010©\u0001\u001a\u00030ª\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u0011\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\bJ\u0011\u0010®\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bJ\n\u0010¯\u0001\u001a\u00030\u0094\u0001H\u0002J\u001c\u0010°\u0001\u001a\u00030\u0094\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010±\u0001\u001a\u00030²\u0001H\u0002J\u0013\u0010³\u0001\u001a\u00030\u0094\u00012\u0007\u0010´\u0001\u001a\u00020bH\u0016J\t\u0010µ\u0001\u001a\u00020$H\u0002J\n\u0010¶\u0001\u001a\u00030\u0094\u0001H\u0002J\u001a\u0010·\u0001\u001a\u00030\u0094\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0014\u0010¸\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0014J7\u0010¹\u0001\u001a\u00030\u0094\u00012\u0007\u0010º\u0001\u001a\u00020$2\u0007\u0010»\u0001\u001a\u00020\b2\u0007\u0010¼\u0001\u001a\u00020\b2\u0007\u0010½\u0001\u001a\u00020\b2\u0007\u0010¾\u0001\u001a\u00020\bH\u0014J\u001c\u0010¿\u0001\u001a\u00030\u0094\u00012\u0007\u0010À\u0001\u001a\u00020\b2\u0007\u0010Á\u0001\u001a\u00020\bH\u0014J\u0014\u0010Â\u0001\u001a\u00030\u0094\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0014J\f\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0014J\u0015\u0010Æ\u0001\u001a\u00030\u0094\u00012\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u0013\u0010È\u0001\u001a\u00030\u0094\u00012\u0007\u0010É\u0001\u001a\u00020$H\u0016J\u0013\u0010Ê\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\bH\u0002J\u001a\u0010Ì\u0001\u001a\u00030\u0094\u00012\u0007\u0010Í\u0001\u001a\u00020\b2\u0007\u0010Î\u0001\u001a\u00020\bJ%\u0010Ï\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010Ð\u0001\u001a\u00020\u001b2\u0007\u0010Ñ\u0001\u001a\u00020\u001bH\u0002J\u0013\u0010Ò\u0001\u001a\u00030\u0094\u00012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010_J\u0013\u0010Ô\u0001\u001a\u00030\u0094\u00012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\\JO\u0010Õ\u0001\u001a\u00030\u0094\u00012\u000f\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010a2\b\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\b2\u001b\u0010Ú\u0001\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`U¢\u0006\u0003\u0010Û\u0001J\u001a\u0010Ü\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\b2\u0007\u0010´\u0001\u001a\u00020bJ\u001a\u0010Ý\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020oJ0\u0010ß\u0001\u001a\u00030\u0094\u00012\u000f\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010a2\u000f\u0010à\u0001\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010a¢\u0006\u0003\u0010á\u0001J\u0011\u0010â\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u001c\u0010ã\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010ä\u0001\u001a\u00020\bH\u0002J\u0012\u0010å\u0001\u001a\u00020\b2\u0007\u0010æ\u0001\u001a\u00020\u001bH\u0002J\n\u0010ç\u0001\u001a\u00030\u0094\u0001H\u0002J\u0013\u0010è\u0001\u001a\u00030\u0094\u00012\u0007\u0010é\u0001\u001a\u00020\bH\u0016J\u0012\u0010ê\u0001\u001a\u00030\u0094\u00012\u0006\u00105\u001a\u00020$H\u0016J\u0013\u0010ë\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\bH\u0002J\u0013\u0010ì\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bH\u0002J\n\u0010í\u0001\u001a\u00030\u0094\u0001H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R&\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001e\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0012R\u000e\u00104\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010<\u001a\u0004\b:\u00107\"\u0004\b=\u00109R$\u0010?\u001a\u00020$2\u0006\u0010>\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u00107\"\u0004\b@\u00109R$\u0010B\u001a\u00020$2\u0006\u0010A\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\u000e\u0010D\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0XX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u000e\u0010d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010n\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010pR\u000e\u0010q\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010x\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010{\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010|\u001a\u00020\b2\u0006\u00101\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0012R$\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00160\u007fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R(\u0010\u0084\u0001\u001a\u00020\u001b2\u0007\u0010\u0084\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010\u001d\"\u0005\b\u0086\u0001\u0010\u001fR(\u0010\u0087\u0001\u001a\u00020\u001b2\u0007\u0010\u0087\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u0010\u001d\"\u0005\b\u0089\u0001\u0010\u001fR(\u0010\u008a\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010\u0012\"\u0005\b\u008c\u0001\u0010\u0014R(\u0010\u008d\u0001\u001a\u00020\u001b2\u0007\u0010\u008d\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010\u001d\"\u0005\b\u008f\u0001\u0010\u001fR(\u0010\u0090\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010\u0012\"\u0005\b\u0092\u0001\u0010\u0014¨\u0006ó\u0001"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barPaint", "Landroid/graphics/Paint;", "barRectF", "Landroid/graphics/RectF;", "barStrokePaint", "barStrokeRectF", "currentTab", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "currentTabView", "Landroid/view/View;", "dividerColor", "getDividerColor", "setDividerColor", "dividerPadding", "", "getDividerPadding", "()F", "setDividerPadding", "(F)V", "dividerWidth", "getDividerWidth", "setDividerWidth", "enableMaterial", "", "indicatorColor", "getIndicatorColor", "setIndicatorColor", EventBody.KEY_VALUE, "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "indicatorDrawable", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "<set-?>", "indicatorSpacing", "getIndicatorSpacing", "initScale", "isBackdropView", "isIndicatorAnimEnable", "()Z", "setIndicatorAnimEnable", "(Z)V", "isIndicatorBounceEnable", "isIndicatorBounceEnable$annotations", "()V", "setIndicatorBounceEnable", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "lastLayoutWidth", "mBarColor", "mBarStrokeColor", "mBarStrokeWidth", "mContainerViewId", "mContentRoot", "mContext", "mCurrentTabIndex", "mDividerColor", "mDividerPadding", "mDividerPaint", "mDividerWidth", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mHeight", "mInitSetMap", "Landroid/util/SparseArray;", "mIsFirstDraw", "mLastTabIndex", "mListener", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "mPressedTab", "mSelectAnimListener", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;", "mTabDrawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "mTabPadding", "mTabSpaceEqual", "mTabWidth", "mTabsContainer", "Landroid/widget/LinearLayout;", "mTextAllCaps", "mTextPaint", "mTextSelectColor", "mTextSize", "mTextUnselectColor", "mTitles", "", "[Ljava/lang/String;", "mVibrateOnTabSelected", "materialApplied", "materialSrcType", "pressAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "pressScale", "releaseAnim", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsPressed", "tabCount", "getTabCount", "tabList", "", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabPadding", "getTabPadding", "setTabPadding", "tabWidth", "getTabWidth", "setTabWidth", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textSize", "getTextSize", "setTextSize", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "addTab", "", "position", "tabView", "applyContentMaterial", "apply", "calcIndicatorRect", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "doPressAnim", "pressed", "dp2px", "dp", "drawBar", "canvas", "Landroid/graphics/Canvas;", "cornerRadius", "drawDivider", "drawIndicator", "drawStroke", "getCurrentFragment", "getMsgView", "Lcom/obric/oui/segmentedtab/UnReadMsgView;", "getTitleView", "Landroid/widget/TextView;", "tab", "hideMsg", "initFragments", "initShadows", "typedArray", "Landroid/content/res/TypedArray;", "invalidateDrawable", "drawable", "isDarkTheme", "notifyDataSetChanged", "obtainAttributes", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setBackdropTarget", "view", "setEnabled", "enabled", "setFragments", "index", "setImageSize", "width", "height", "setMsgMargin", "leftPadding", "bottomPadding", "setOnTabSelectAnimListener", "listener", "setOnTabSelectListener", "setTabData", "titles", "fa", "Landroidx/fragment/app/FragmentActivity;", "containerViewId", "fragments", "([Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;ILjava/util/ArrayList;)V", "setTabDrawable", "setTabTitle", "title", "setTabTitleAndDrawable", "drawables", "([Ljava/lang/String;[Landroid/graphics/drawable/Drawable;)V", "showDot", "showMsg", "num", "sp2px", "sp", "trackNewTabPosition", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateTabContent", "updateTabSelection", "updateTabStyles", "Companion", "IndicatorPoint", "PointEvaluator", "TabSelectAnimListener", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavActionBar extends OUIFrameLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14420a = null;
    private boolean A;
    private int B;
    private int C;
    private float D;
    private int E;
    private boolean F;
    private FragmentManager G;
    private ArrayList<Fragment> H;
    private List<k> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private List<k> f14421J;
    private final Paint K;
    private final Paint L;
    private final RectF M;
    private final RectF N;
    private com.obric.common.oea.foundation.animation.d.d O;
    private com.obric.common.oea.foundation.animation.d.d P;
    private float Q;
    private float R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private int W;
    private boolean aa;
    private float ab;
    private final Paint ac;
    private final SparseArray<Boolean> ad;
    private c ae;
    private b af;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14422b;
    private String[] c;
    private Drawable[] d;
    private final LinearLayout e;
    private OUIFrameLayout f;
    private int g;
    private View h;
    private List<View> i;
    private int j;
    private int k;
    private int l;
    private final Paint m;
    private float n;
    private boolean o;
    private float p;
    private final com.obric.oui.segmentedtab.a q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private float v;
    private float w;
    private float x;
    private int y;
    private int z;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$Companion;", "", "()V", "TAB_ANIM_DURATION", "", "TAG", "", "TEXT_BOLD_BOTH", "", "TEXT_BOLD_NONE", "TEXT_BOLD_WHEN_SELECT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;", "", "onSelectAnimCancel", "", "onSelectAnimEnd", "onSelectAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a();

        void b();

        void c();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(int r1);

        void b(int r1);
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/obric/oui/segmentedtab/OBottomNavActionBar$setOnTabSelectAnimListener$1", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable$AnimListener;", "onAnimCancel", "", "onAnimEnd", "onAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements com.obric.oui.segmentedtab.a.InterfaceC0773a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomNavActionBar f14423a;

        d(OBottomNavActionBar r1) {
            this.f14423a = r1;
        }

        @Override // com.obric.oui.segmentedtab.a.InterfaceC0773a
        public void a() {
            b r0 = OBottomNavActionBar.a(this.f14423a);
            if (r0 == null) goto L7;
            r0.a();
            return;
        }

        @Override // com.obric.oui.segmentedtab.a.InterfaceC0773a
        public void b() {
            b r0 = OBottomNavActionBar.a(this.f14423a);
            if (r0 == null) goto L7;
            r0.b();
            return;
        }

        @Override // com.obric.oui.segmentedtab.a.InterfaceC0773a
        public void c() {
            b r0 = OBottomNavActionBar.a(this.f14423a);
            if (r0 == null) goto L7;
            r0.c();
            return;
        }
    }

    static {
        f14420a = new a(null);
    }

    public OBottomNavActionBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBottomNavActionBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBottomNavActionBar(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15, r13, null, 8, null);
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.j = -1;
        this.m = new Paint(1);
        this.q = new com.obric.oui.segmentedtab.a();
        this.s = true;
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        this.K = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        this.L = r1;
        this.M = new RectF();
        this.N = new RectF();
        this.Q = 0.988f;
        this.R = 1.0f;
        this.U = true;
        this.V = -1;
        this.W = -1;
        if (l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        boolean r16 = false;
    L8:
        this.S = r16;
        this.T = r16;
        this.aa = true;
        this.ac = new Paint(1);
        this.ad = new SparseArray();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f14422b = ZeusTransformUtils.wrapperContext(r14, "com.obric.memorydata.plugin");
        this.e = new LinearLayout(r14);
        OUIFrameLayout r17 = new OUIFrameLayout(r14, null, 0, null, 14, null);
        this.f = r17;
        r17.setRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        this.f.setChangeAlphaWhenPress(false);
        this.f.setChangeAlphaWhenDisable(false);
        this.f.setChangeAlphaWhenSelected(false);
        addView((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r15);
        String r18 = r15.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r18, StructuredDataId.RESERVED) == false) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r18, "-2") == true) goto L17;
        TypedArray r19 = r14.obtainStyledAttributes(r15, new int[]{R.attr.layout_height});
        Intrinsics.checkNotNullExpressionValue(r19, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.E = r19.getDimensionPixelSize(0, -2);
        r19.recycle();
        return;
    L17:
        return;
    L5:
        if (OMaterialHelper.d() == false) goto L7;
        r16 = true;
        goto L8
    }

    public /* synthetic */ OBottomNavActionBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final int a(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.f14422b, "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    public static final /* synthetic */ b a(OBottomNavActionBar r0) {
        return r0.af;
    }

    private final void a() {
        this.aa = true;
        this.e.removeAllViews();
        String[] r0 = this.c;
        if (r0 != null) goto L5;
        Integer r1 = null;
    L6:
        int r2 = 0;
        if (r1 != null) goto L12;
        Drawable[] r3 = this.d;
        if (r3 != null) goto L11;
        int r4 = 0;
    L13:
        this.l = r4;
        this.i.clear();
        int r5 = this.l;
    L14:
        if (r2 >= r5) goto L16;
        OSegmentTabView r6 = OSegmentTabView.f14433a.a(this.f14422b);
        r6.a(this.y, this.z);
        r6.setOriginIconAlpha(255);
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
        ((OSegmentTabView) ZeusTransformUtils.preCheckCast(r7, OSegmentTabView.class, "com.obric.memorydata.plugin")).setTag(Integer.valueOf(r2));
        a(r2, r7);
        r2 = r2 + 1;
        goto L14
    L16:
        b();
        return;
    L11:
        r4 = r3.length;
        goto L13
    L12:
        r4 = r1.intValue();
        goto L13
    L5:
        r1 = Integer.valueOf(r0.length);
        goto L6
    }

    private final void a(int r6, float r7, float r8) {
        int r0 = this.l;
        if (r6 < r0) goto L5;
        r6 = r0 - 1;
    L5:
        View r9 = this.e.getChildAt(r6);
        View r1 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.rtv_msg_tip, OaidModel.KEY_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        UnReadMsgView r2 = (UnReadMsgView) ZeusTransformUtils.preCheckCast(r1, UnReadMsgView.class, "com.obric.memorydata.plugin");
        View r10 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_title, OaidModel.KEY_ID, "tv_tab_title"));
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.widget.TextView");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
        this.ac.setTextSize(this.x);
        this.ac.measureText(r11.getText().toString());
        float r12 = this.ac.descent() - this.ac.ascent();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r4.leftMargin = a(r7);
        int r13 = this.E;
        if (r13 <= 0) goto L8;
        int r14 = (((int) (r13 - r12)) / 2) - a(r8);
    L9:
        r4.topMargin = r14;
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r14 = a(r8);
        goto L9
    }

    private final void a(int r6, int r7) {
        int r0 = this.l;
        if (r6 < r0) goto L5;
        r6 = r0 - 1;
    L5:
        View r1 = this.e.getChildAt(r6).findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.rtv_msg_tip, OaidModel.KEY_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        ((UnReadMsgView) ZeusTransformUtils.preCheckCast(r1, UnReadMsgView.class, "com.obric.memorydata.plugin")).show(r7);
        if (this.ad.get(r6) == null) goto L10;
        Boolean r8 = this.ad.get(r6);
        Intrinsics.checkNotNull(r8);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
        return;
    L10:
        a(r6, 2.0f, 2.0f);
        this.ad.put(r6, true);
    }

    private final void a(int r11, View r12) {
        View r1 = r12.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_title, OaidModel.KEY_ID, "tv_tab_title"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin");
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_icon, OaidModel.KEY_ID, "tv_tab_icon")), ImageView.class, "com.obric.memorydata.plugin");
        int r4 = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2);
        String[] r5 = this.c;
        Unit r7 = null;
        Drawable r8 = null;
        if (r5 != null) goto L6;
        Unit r6 = null;
    L15:
        if (r6 != null) goto L17;
        OBottomNavActionBar r9 = (OBottomNavActionBar) ZeusTransformUtils.preCheckCast(this, OBottomNavActionBar.class, "com.obric.memorydata.plugin");
        r2.setVisibility(8);
    L17:
        Drawable[] r10 = this.d;
        if (r10 == null) goto L24;
        if (r10 == null) goto L23;
        r8 = r10[r11];
    L23:
        r3.setImageDrawable(r8);
        r7 = Unit.INSTANCE;
    L24:
        if (r7 != null) goto L26;
        OBottomNavActionBar r0 = (OBottomNavActionBar) ZeusTransformUtils.preCheckCast(this, OBottomNavActionBar.class, "com.obric.memorydata.plugin");
        r3.setVisibility(8);
        ViewGroup.LayoutParams r13 = r2.getLayoutParams();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r13, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r14.setMargins(0, r4, 0, 0);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L26:
        r12.setOnTouchListener(new $$Lambda$OBottomNavActionBar$ZR3DO3w81qPyuE99SfhCRXokPAA(this));
        r12.setOnClickListener(new $$Lambda$OBottomNavActionBar$mkJYJd9TKBJW9pqan3qD7gLIFk8(this));
        this.i.add(r12);
        if (this.o == false) goto L29;
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L31:
        if (this.p <= 0.0f) goto L33;
        r15 = new LinearLayout.LayoutParams((int) this.p, -1);
    L33:
        this.e.addView(r12, r11, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L29:
        r15 = new LinearLayout.LayoutParams(-2, -1);
        goto L31
    L6:
        if (r5 != null) goto L9;
    L7:
        Object r16 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L13:
        r2.setText((CharSequence) r16);
        ViewGroup.LayoutParams r17 = r2.getLayoutParams();
        Objects.requireNonNull(r17, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r17, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r18.setMargins(0, r4, 0, 0);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6 = Unit.INSTANCE;
        goto L15
    L9:
        String r19 = r5[r11];
        if (r19 == null) goto L7;
        r16 = ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin");
        goto L13
    }

    private final void a(Context r6, TypedArray r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        List<k> r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_shadow_normal, "styleable", "OTabLayout_shadow_normal"));
        if (r0 != null) goto L5;
        r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetShadowNormal, "styleable", "OTabLayout_oui_widgetShadowNormal"));
    L5:
        if (r0 == null) goto L7;
        this.I = r0;
        Intrinsics.checkNotNull(r0);
        k r1 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r0, 0), k.class, "com.obric.memorydata.plugin");
        List<k> r3 = this.I;
        Intrinsics.checkNotNull(r3);
        a(r1, (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r3, 1), k.class, "com.obric.memorydata.plugin"));
    L7:
        List<k> r2 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_shadow_pressed, "styleable", "OTabLayout_shadow_pressed"));
        if (r2 != null) goto L10;
        r2 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetShadowPressed, "styleable", "OTabLayout_oui_widgetShadowPressed"));
    L10:
        if (r2 == null) goto L13;
        this.f14421J = r2;
        return;
    }

    private final void a(Canvas r11) {
        if (this.q.e() == true) goto L9;
        float r0 = this.v;
        if (r0 <= 0.0f) goto L11;
        this.m.setStrokeWidth(r0);
        this.m.setColor(this.u);
        int r1 = 0;
        int r2 = this.l - 1;
    L7:
        if (r1 >= r2) goto L12;
        int r3 = r1 + 1;
        View r4 = this.e.getChildAt(r1);
        r11.drawLine(getPaddingLeft() + r4.getRight(), this.w, getPaddingLeft() + r4.getRight(), getHeight() - this.w, this.m);
        r1 = r3;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private final void a(Canvas r7, float r8) {
        if (this.T == false) goto L5;
        return;
    L5:
        this.K.setColor(this.B);
        this.M.set(0.0f, getPaddingTop(), getWidth(), getHeight() - getPaddingBottom());
        m.a(r7, this.M, r8, this.K);
    }

    private static final void a(OBottomNavActionBar r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r3.F == false) goto L5;
        com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
    L5:
        Object r5 = r4.getTag();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r3.setCurrentTab(((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue());
    }

    private static final boolean a(OBottomNavActionBar r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        Object r5 = r2.getTag();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L10:
        r1.j = r6;
        r1.postInvalidate();
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r6 = -1;
        goto L10
    L7:
        if (r4 == 3) goto L9;
        return false;
    }

    private final int b(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.f14422b, "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void b() {
        int r0 = this.l;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        int r3 = r2 + 1;
        View r4 = this.e.getChildAt(r2);
        float r5 = this.n;
        r4.setPadding((int) r5, 0, (int) r5, 0);
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_title, OaidModel.KEY_ID, "tv_tab_title"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
        if (r2 != this.g) goto L7;
        boolean r8 = true;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabView.class) == false) goto L12;
        ((OSegmentTabView) ZeusTransformUtils.preCheckCast(r4, OSegmentTabView.class, "com.obric.memorydata.plugin")).a(r8);
    L11:
        r7.setTextSize(0, this.x);
        ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_icon, OaidModel.KEY_ID, "tv_tab_icon")), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == false) goto L19;
        int r10 = this.y;
    L20:
        r9.setImageTintList(ColorStateList.valueOf(r10));
        if (this.A == false) goto L23;
        String r11 = r7.getText().toString();
        Locale r12 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r12, "ROOT");
        String r13 = r11.toUpperCase(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toUpperCase(locale)");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
    L23:
        if (r8 == false) goto L25;
        this.h = r4;
    L25:
        r2 = r3;
        goto L3
    L19:
        r10 = this.z;
        goto L20
    L12:
        if (r8 == false) goto L14;
        int r14 = this.y;
    L15:
        r7.setTextColor(r14);
        goto L11
    L14:
        r14 = this.z;
        goto L15
    L7:
        r8 = false;
        goto L9
    }

    private final void b(Canvas r3) {
        if (this.q.e() == true) goto L5;
    L7:
        d();
    L8:
        r3.translate(getPaddingLeft(), getPaddingTop());
        this.q.draw(r3);
        r3.translate(-getPaddingLeft(), -getPaddingTop());
        return;
    L5:
        if (this.aa == false) goto L8;
        this.aa = false;
        goto L7
    }

    private final void b(Canvas r8, float r9) {
        if (this.D <= 0.0f) goto L6;
        this.L.setColor(this.C);
        this.L.setStrokeWidth(this.D);
        float r2 = 2;
        this.N.set(this.D / r2, getPaddingTop() + (this.D / r2), getWidth() - (this.D / r2), (getHeight() - getPaddingBottom()) - (this.D / r2));
        m.a(r8, this.N, r9, this.L);
        return;
    }

    private final void b(boolean r5) {
        com.obric.common.oea.foundation.animation.d.d r0 = this.O;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a(r0, false, 1, null);
    L6:
        com.obric.common.oea.foundation.animation.d.d r1 = this.P;
        if (r1 == null) goto L11;
        com.obric.common.oea.foundation.animation.d.d.a(r1, false, 1, null);
    L11:
        if (r5 == false) goto L13;
        this.O = com.obric.oui.common.style.l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.R, this.Q, getCurrentShadows(), this.f14421J);
        return;
    L13:
        this.P = com.obric.oui.common.style.l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.Q, this.R, getCurrentShadows(), this.I);
    }

    private final void c() {
        View r0 = this.h;
        Intrinsics.checkNotNull(r0);
        float r1 = r0.getLeft();
        View r2 = this.h;
        Intrinsics.checkNotNull(r2);
        float r3 = r2.getRight();
        com.obric.oui.segmentedtab.a r4 = this.q;
        r4.b(r1, this.r, r3 - r1, r4.d());
    }

    private final void d() {
        if (this.q.a() == true) goto L6;
        View r0 = this.h;
        Intrinsics.checkNotNull(r0);
        float r1 = r0.getLeft();
        View r2 = this.h;
        Intrinsics.checkNotNull(r2);
        float r3 = r2.getRight();
        com.obric.oui.segmentedtab.a r4 = this.q;
        r4.a(r1, this.r + this.D, r3 - r1, r4.d());
        return;
    }

    private final void e(int r9) {
        int r0 = this.l;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        int r3 = r2 + 1;
        View r4 = this.e.getChildAt(r2);
        if (r2 != r9) goto L7;
        boolean r5 = true;
    L8:
        ImageView r6 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_icon, OaidModel.KEY_ID, "tv_tab_icon")), ImageView.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L11;
        int r7 = this.y;
    L12:
        r6.setImageTintList(ColorStateList.valueOf(r7));
        com.obric.oui.c.c r8 = com.obric.oui.c.c.f13403a;
        View r10 = null;
        if (r4 != null) goto L16;
    L18:
        OSegmentTabView r11 = (OSegmentTabView) ZeusTransformUtils.preCheckCast(r10, OSegmentTabView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L22;
        r11.a(r5);
    L22:
        if (r5 == false) goto L24;
        this.h = r4;
    L24:
        r2 = r3;
        goto L3
    L16:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabView.class) == false) goto L18;
        r10 = r4;
        goto L18
    L11:
        r7 = this.z;
        goto L12
    L7:
        r5 = false;
        goto L8
    }

    public static /* synthetic */ boolean lambda$ZR3DO3w81qPyuE99SfhCRXokPAA(OBottomNavActionBar r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$mkJYJd9TKBJW9pqan3qD7gLIFk8(OBottomNavActionBar r0, View r1) {
        a(r0, r1);
    }

    private final void setFragments(int r8) {
        ArrayList<Fragment> r0 = this.H;
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L6:
        if (r1 >= r2) goto L12;
        int r3 = r1 + 1;
        FragmentManager r4 = this.G;
        Intrinsics.checkNotNull(r4);
        FragmentTransaction r5 = r4.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r6 = this.H;
        Intrinsics.checkNotNull(r6);
        Fragment r7 = r6.get(r1);
        Intrinsics.checkNotNullExpressionValue(r7, "mFragments!![i]");
        Fragment r9 = (Fragment) ZeusTransformUtils.preCheckCast(r7, Fragment.class, "com.obric.memorydata.plugin");
        if (r1 != r8) goto L10;
        r5.show(r9);
    L11:
        r5.commit();
        r1 = r3;
        goto L6
    L10:
        r5.hide(r9);
        goto L11
    L12:
        this.g = r8;
        return;
    }

    public final void a(int r2) {
        int r0 = this.l;
        if (r2 < r0) goto L5;
        r2 = r0 - 1;
    L5:
        a(r2, 0);
    }

    public final void a(Context r14, AttributeSet r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r15, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "context");
        this.q.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.memorydata.plugin"));
        TypedArray r18 = r16.obtainStyledAttributes(r17, com.obric.memorydata.plugin.R.styleable.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r18, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.q.a(r18.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_color, "styleable", "OTabLayout_indicator_color"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_fill_element_3, TypedValues.Custom.S_COLOR, "oui_fill_element_3"))));
        this.q.b(r18.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_height, "styleable", "OTabLayout_indicator_height"), -1.0f));
        this.q.a(r18.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_corner_radius, "styleable", "OTabLayout_indicator_corner_radius"), -1.0f));
        setIndicatorCornerRadius(this.q.c());
        this.r = r18.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_spacing, "styleable", "OTabLayout_indicator_spacing"), a(4.0f));
        this.q.a(r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_anim_enable, "styleable", "OTabLayout_indicator_anim_enable"), false));
        this.t = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_bounce_enable, "styleable", "OTabLayout_indicator_bounce_enable"), true);
        this.e.setPadding(getIndicatorSpacing(), 0, getIndicatorSpacing(), 0);
        this.f.addView((View) ZeusTransformUtils.preCheckCast(this.e, View.class, "com.obric.memorydata.plugin"));
        this.u = r18.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_color, "styleable", "OTabLayout_divider_color"), this.q.b());
        this.v = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_width, "styleable", "OTabLayout_divider_width"), 0.0f);
        this.w = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_padding, "styleable", "OTabLayout_divider_padding"), 0.0f);
        this.x = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textSize, "styleable", "OTabLayout_tab_textSize"), a(10.0f));
        this.y = r18.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textSelectColor, "styleable", "OTabLayout_tab_textSelectColor"), this.f14422b.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1")));
        this.z = r18.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textUnselectColor, "styleable", "OTabLayout_tab_textUnselectColor"), this.f14422b.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_text_3b, TypedValues.Custom.S_COLOR, "oui_text_3b")));
        this.A = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textAllCaps, "styleable", "OTabLayout_tab_textAllCaps"), false);
        this.o = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_space_equal, "styleable", "OTabLayout_tab_space_equal"), true);
        this.p = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_width, "styleable", "OTabLayout_tab_width"), a(-1.0f));
        int r0 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_padding, "styleable", "OTabLayout_tab_padding");
        if (this.o == false) goto L5;
    L8:
        int r4 = a(0.0f);
    L9:
        this.n = r18.getDimension(r0, r4);
        this.B = r18.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), 0);
        this.C = r18.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_stroke_color, "styleable", "OTabLayout_bar_stroke_color"), this.B);
        this.D = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_stroke_width, "styleable", "OTabLayout_bar_stroke_width"), a(0.0f));
        this.F = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_vibrate_on_tab_selected, "styleable", "OTabLayout_vibrate_on_tab_selected"), false);
        a(r16, r18);
        setShadowCornerRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        if (this.S == false) goto L29;
        this.V = r18.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetMaterialSrcType, "styleable", "OTabLayout_oui_widgetMaterialSrcType"), -1);
        String r19 = r18.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetMaterial, "styleable", "OTabLayout_oui_widgetMaterial"));
        if (r19 != null) goto L14;
        r19 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_material_bg_floating, TypedValues.Custom.S_STRING, "oui_material_bg_floating"));
    L14:
        com.obric.oui.material.c[] r7 = MaterialToken.parseSet(r19, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")));
        if (r7 == null) goto L17;
        boolean r110 = true;
    L18:
        this.S = r110;
        this.T = r110;
        r18.recycle();
        if (this.T == false) goto L30;
        setEnableShadowWidthRadius(true);
        setRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        if (r7 == null) goto L31;
        int r111 = this.V;
        if (r111 != (-1)) goto L27;
        r111 = 2;
    L27:
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r7, false, r111, null, 10, null);
        GradientDrawable r112 = new GradientDrawable();
        r112.setShape(0);
        r112.setCornerRadius(com.obric.oui.common.util.h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        r112.setColor(0);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r112, Drawable.class, "com.obric.memorydata.plugin"));
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        r110 = false;
        goto L18
    L29:
        return;
    L5:
        if (this.p > 0.0f) goto L8;
        r4 = a(10.0f);
        goto L9
    }

    public void a(boolean r5) {
        if (this.T != r5) goto L5;
        return;
    L5:
        this.T = r5;
        com.obric.oui.material.i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.T, this.U);
        if (this.T == false) goto L8;
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(0);
        r6.setCornerRadius(com.obric.oui.common.util.h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        r6.setColor(0);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r6, Drawable.class, "com.obric.memorydata.plugin"));
    L8:
        invalidate();
    }

    public final void a(String[] r4, Drawable[] r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L23;
        if (r5 != null) goto L15;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == false) goto L23;
    L24:
        if (r0 == false) goto L28;
        this.c = r4;
        this.d = r5;
        a();
        return;
    L28:
        throw new IllegalStateException("Titles and Drawables can not be NULL or EMPTY !".toString());
    L15:
        if (r5.length != 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L21;
        r3 = false;
        goto L22
    L17:
        r6 = false;
    L23:
        r0 = true;
        goto L24
    L5:
        if (r4.length != 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r7 = false;
        goto L8
    }

    @Override // com.obric.oui.material.h
    public void b(int r3) {
        this.V = r3;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void c(int r3) {
        int r0 = this.l;
        if (r3 < r0) goto L5;
        r3 = r0 - 1;
    L5:
        View r2 = this.e.getChildAt(r3).findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.rtv_msg_tip, OaidModel.KEY_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        ((UnReadMsgView) ZeusTransformUtils.preCheckCast(r2, UnReadMsgView.class, "com.obric.memorydata.plugin")).setVisibility(8);
    }

    public final UnReadMsgView d(int r3) {
        int r0 = this.l;
        if (r3 < r0) goto L5;
        r3 = r0 - 1;
    L5:
        View r2 = this.e.getChildAt(r3).findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.rtv_msg_tip, OaidModel.KEY_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        return (UnReadMsgView) ZeusTransformUtils.preCheckCast(r2, UnReadMsgView.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        b(false);
    L11:
        return super.dispatchTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L9:
        b(true);
        goto L11
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r0 = this.H;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (Fragment) ZeusTransformUtils.preCheckCast(r0.get(this.g), Fragment.class, "com.obric.memorydata.plugin");
    }

    public final int getCurrentTab() {
        return this.g;
    }

    public final int getDividerColor() {
        return this.u;
    }

    public final float getDividerPadding() {
        return this.w;
    }

    public final float getDividerWidth() {
        return this.v;
    }

    public final int getIndicatorColor() {
        return this.q.b();
    }

    public final float getIndicatorCornerRadius() {
        return this.ab;
    }

    public final float getIndicatorHeight() {
        return this.q.d();
    }

    public final int getIndicatorSpacing() {
        return this.r;
    }

    public final int getTabCount() {
        return this.l;
    }

    public final List<View> getTabList() {
        return this.i;
    }

    public final float getTabPadding() {
        return this.n;
    }

    public final float getTabWidth() {
        return this.p;
    }

    public final int getTextSelectColor() {
        return this.y;
    }

    public final float getTextSize() {
        return this.x;
    }

    public final int getTextUnselectColor() {
        return this.z;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super.invalidateDrawable(r2);
        if (Intrinsics.areEqual(r2, this.q) == false) goto L6;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.l <= 0) goto L10;
        float r0 = this.q.c() + (this.r / 2);
        a(r3, r0);
        b(r3, r0);
        a(r3);
        b(r3);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.q.a(getHeight(), this.r);
        if (getWidth() == this.W) goto L6;
        this.W = getWidth();
        this.aa = true;
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L12;
        int r0 = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin")).getInt("mCurrentTab");
        this.g = r0;
        this.k = r0;
        r5 = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin")).getParcelable("instanceState");
        if (this.g == 0) goto L12;
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.e, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() == 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        e(this.g);
        goto L12
    L9:
        r1 = false;
    L12:
        super.onRestoreInstanceState(r5);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putInt("mCurrentTab", this.g);
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        return (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r3) {
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setCurrentTab(int r3) {
        int r0 = this.g;
        if (r3 != r0) goto L10;
        c r2 = this.ae;
        if (r2 == null) goto L20;
        if (r2 == null) goto L21;
        r2.a(r0);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        this.aa = true;
        this.k = r0;
        this.g = r3;
        e(r3);
        setFragments(r3);
        c r4 = this.ae;
        if (r4 == null) goto L16;
        if (r4 == null) goto L16;
        r4.b(this.g);
    L16:
        if (this.q.e() == false) goto L18;
        c();
        return;
    L18:
        invalidate();
    }

    public final void setDividerColor(int r1) {
        this.u = r1;
        invalidate();
    }

    public final void setDividerPadding(float r1) {
        this.w = a(r1);
        invalidate();
    }

    public final void setDividerWidth(float r1) {
        this.v = a(r1);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        Iterator<View> r3 = this.i.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin")).setEnabled(r4);
        goto L4
    }

    public final void setIndicatorAnimEnable(boolean r1) {
        this.s = r1;
    }

    public final void setIndicatorBounceEnable(boolean r1) {
        this.t = r1;
    }

    public final void setIndicatorColor(int r1) {
        this.q.a(r1);
    }

    public final void setIndicatorCornerRadius(float r2) {
        this.q.a(a(r2));
        this.ab = this.q.c();
    }

    public final void setIndicatorHeight(float r2) {
        this.q.b(a(r2));
    }

    public final void setOnTabSelectAnimListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.af = r4;
        if (r4 != null) goto L6;
        this.q.a(null);
        return;
    L6:
        this.q.a((com.obric.oui.segmentedtab.a.InterfaceC0773a) ZeusTransformUtils.preCheckCast(new d(this), com.obric.oui.segmentedtab.a.InterfaceC0773a.class, "com.obric.memorydata.plugin"));
    }

    public final void setOnTabSelectListener(c r3) {
        this.ae = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void setTabList(List<View> r3) {
        List<View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.i = r4;
    }

    public final void setTabPadding(float r1) {
        this.n = a(r1);
        b();
    }

    public final void setTabSpaceEqual(boolean r1) {
        this.o = r1;
        b();
    }

    public final void setTabWidth(float r1) {
        this.p = a(r1);
        b();
    }

    public final void setTextAllCaps(boolean r1) {
        this.A = r1;
        b();
    }

    public final void setTextSelectColor(int r1) {
        this.y = r1;
        b();
    }

    public final void setTextSize(float r1) {
        this.x = b(r1);
        b();
    }

    public final void setTextUnselectColor(int r1) {
        this.z = r1;
        b();
    }
}
