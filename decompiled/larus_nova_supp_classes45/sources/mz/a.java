package mz;

import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.api.IAnchorLevel;
import com.bytedance.android.live.base.model.user.d0;
import com.bytedance.android.live.base.model.user.g0;
import com.bytedance.android.live.base.model.user.j;
import com.bytedance.android.live.base.model.user.l0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.t;
import com.bytedance.android.live.base.model.user.x;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.d;
import py.f;
import py.k;
import py.o;
import py.q;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 Â\u00022\u00020\u0001:\u0002Ã\u0002B\t¢\u0006\u0006\bÀ\u0002\u0010Á\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\u0002H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0015H\u0016J\u0010\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J\u0012\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\n\u0010.\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0002H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u0012\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u000102H\u0016J\n\u00107\u001a\u0004\u0018\u000106H\u0016J\u0012\u00109\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u000106H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010=\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010?\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010@\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010A\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010B\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010C\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J\b\u0010D\u001a\u00020\u0002H\u0016J\b\u0010E\u001a\u00020\u0002H\u0016J\b\u0010F\u001a\u00020\u0002H\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0002H\u0016J\n\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0018H\u0016J\b\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010N\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J\u0018\u0010Q\u001a\u00020\u00052\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010OH\u0016J\b\u0010S\u001a\u00020RH\u0016J\n\u0010U\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010W\u001a\u00020\u00052\b\u0010V\u001a\u0004\u0018\u00010TH\u0016J\b\u0010X\u001a\u00020\u0010H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010[\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\\\u001a\u00020\u0002H\u0016J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0002H\u0016J\u0010\u0010`\u001a\u00020\u00052\u0006\u0010_\u001a\u00020\u0018H\u0016J\b\u0010a\u001a\u00020\u0018H\u0016J\b\u0010b\u001a\u00020\u0018H\u0016J\u0010\u0010d\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0018H\u0016J\b\u0010e\u001a\u00020\u0002H\u0016J\n\u0010f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010h\u001a\u0004\u0018\u00010gH\u0016J\b\u0010i\u001a\u00020\u0010H\u0016J\u0012\u0010k\u001a\u00020\u00052\b\u0010j\u001a\u0004\u0018\u00010\u0010H\u0016J-\u0010o\u001a\u00028\u0000\"\u000e\b\u0000\u0010m*\b\u0012\u0004\u0012\u00020I0l2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000nH\u0016¢\u0006\u0004\bo\u0010pJ/\u0010q\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010m*\b\u0012\u0004\u0012\u00020I0l2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000nH\u0016¢\u0006\u0004\bq\u0010pR*\u0010s\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0097\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010}\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R'\u0010\u0082\u0001\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\u000e\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010G\u001a\u00020\u00022\u0006\u0010r\u001a\u00020\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R)\u0010\u0089\u0001\u001a\u00020\u00022\u0006\u0010r\u001a\u00020\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0087\u0001\u0010\u0084\u0001\"\u0006\b\u0088\u0001\u0010\u0086\u0001R+\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008a\u0001\u0010z\"\u0005\b\u008b\u0001\u0010|R+\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0001\u0010z\"\u0005\b\u008e\u0001\u0010|R/\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0090\u00012\t\u0010r\u001a\u0005\u0018\u00010\u0090\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R'\u0010\u0098\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0096\u0001\u0010v\"\u0005\b\u0097\u0001\u0010xR'\u0010\u009b\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0099\u0001\u0010v\"\u0005\b\u009a\u0001\u0010xR+\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009c\u0001\u0010z\"\u0005\b\u009d\u0001\u0010|R&\u0010_\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010v\"\u0005\b \u0001\u0010xR,\u0010¤\u0001\u001a\u0017\u0012\u0004\u0012\u00020I\u0018\u00010Oj\u000b\u0012\u0004\u0012\u00020I\u0018\u0001`¡\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010£\u0001R)\u0010¥\u0001\u001a\u00020\u00022\u0006\u0010r\u001a\u00020\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¥\u0001\u0010\u0084\u0001\"\u0006\b¦\u0001\u0010\u0086\u0001R+\u0010©\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b§\u0001\u0010z\"\u0005\b¨\u0001\u0010|R,\u0010«\u0001\u001a\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010Oj\u000b\u0012\u0004\u0012\u00020\r\u0018\u0001`¡\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010£\u0001R/\u0010±\u0001\u001a\u0005\u0018\u00010¬\u00012\t\u0010r\u001a\u0005\u0018\u00010¬\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010µ\u0001\u001a\u0005\u0018\u00010²\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010´\u0001R+\u0010¸\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¶\u0001\u0010z\"\u0005\b·\u0001\u0010|R-\u0010½\u0001\u001a\u0004\u0018\u00010\r2\b\u0010r\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R+\u0010À\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¾\u0001\u0010z\"\u0005\b¿\u0001\u0010|R'\u0010Ã\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÁ\u0001\u0010v\"\u0005\bÂ\u0001\u0010xR\u0018\u00104\u001a\u0004\u0018\u0001028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R,\u00108\u001a\u0004\u0018\u0001062\b\u0010r\u001a\u0004\u0018\u0001068V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R/\u0010Ï\u0001\u001a\u0005\u0018\u00010Ê\u00012\t\u0010r\u001a\u0005\u0018\u00010Ê\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R+\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÐ\u0001\u0010z\"\u0005\bÑ\u0001\u0010|R,\u0010<\u001a\u0004\u0018\u00010:2\b\u0010r\u001a\u0004\u0018\u00010:8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R+\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b×\u0001\u0010z\"\u0005\bØ\u0001\u0010|R'\u0010Ü\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÚ\u0001\u0010v\"\u0005\bÛ\u0001\u0010xR'\u0010ß\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÝ\u0001\u0010v\"\u0005\bÞ\u0001\u0010xR(\u0010â\u0001\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\bà\u0001\u0010\u007f\"\u0006\bá\u0001\u0010\u0081\u0001R'\u0010å\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bã\u0001\u0010v\"\u0005\bä\u0001\u0010xR'\u0010è\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bæ\u0001\u0010v\"\u0005\bç\u0001\u0010xR(\u0010ë\u0001\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\bé\u0001\u0010\u007f\"\u0006\bê\u0001\u0010\u0081\u0001R(\u0010î\u0001\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\bì\u0001\u0010\u007f\"\u0006\bí\u0001\u0010\u0081\u0001R'\u0010ñ\u0001\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bï\u0001\u0010v\"\u0005\bð\u0001\u0010xR+\u0010ô\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bò\u0001\u0010z\"\u0005\bó\u0001\u0010|R+\u0010÷\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bõ\u0001\u0010z\"\u0005\bö\u0001\u0010|R;\u0010û\u0001\u001a\u000b\u0018\u00010\rj\u0005\u0018\u0001`ø\u00012\u000f\u0010r\u001a\u000b\u0018\u00010\rj\u0005\u0018\u0001`ø\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bù\u0001\u0010º\u0001\"\u0006\bú\u0001\u0010¼\u0001R\u001a\u0010ÿ\u0001\u001a\u0005\u0018\u00010ü\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001R(\u0010\u0082\u0002\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b\u0080\u0002\u0010\u007f\"\u0006\b\u0081\u0002\u0010\u0081\u0001R/\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0083\u00022\t\u0010r\u001a\u0005\u0018\u00010\u0083\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0006\b\u0086\u0002\u0010\u0087\u0002R/\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u0089\u00022\t\u0010r\u001a\u0005\u0018\u00010\u0089\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R/\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u008f\u00022\t\u0010r\u001a\u0005\u0018\u00010\u008f\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R'\u0010\u0097\u0002\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0095\u0002\u0010v\"\u0005\b\u0096\u0002\u0010xR-\u0010\u009a\u0002\u001a\u0004\u0018\u00010\r2\b\u0010r\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0098\u0002\u0010º\u0001\"\u0006\b\u0099\u0002\u0010¼\u0001R/\u0010 \u0002\u001a\u0005\u0018\u00010\u009b\u00022\t\u0010r\u001a\u0005\u0018\u00010\u009b\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0006\b\u009e\u0002\u0010\u009f\u0002R,\u0010¢\u0002\u001a\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010Oj\u000b\u0012\u0004\u0012\u00020\r\u0018\u0001`¡\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¡\u0002\u0010£\u0001R'\u0010¥\u0002\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b£\u0002\u0010v\"\u0005\b¤\u0002\u0010xR)\u0010¦\u0002\u001a\u00020\u00022\u0006\u0010r\u001a\u00020\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¦\u0002\u0010\u0084\u0001\"\u0006\b§\u0002\u0010\u0086\u0001R(\u0010ª\u0002\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b¨\u0002\u0010\u007f\"\u0006\b©\u0002\u0010\u0081\u0001R(\u0010\u00ad\u0002\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b«\u0002\u0010\u007f\"\u0006\b¬\u0002\u0010\u0081\u0001R+\u0010°\u0002\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b®\u0002\u0010z\"\u0005\b¯\u0002\u0010|R/\u0010¶\u0002\u001a\u0005\u0018\u00010±\u00022\t\u0010r\u001a\u0005\u0018\u00010±\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b²\u0002\u0010³\u0002\"\u0006\b´\u0002\u0010µ\u0002R/\u0010¼\u0002\u001a\u0005\u0018\u00010·\u00022\t\u0010r\u001a\u0005\u0018\u00010·\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R+\u0010¿\u0002\u001a\u0004\u0018\u00010\u00102\b\u0010r\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b½\u0002\u0010z\"\u0005\b¾\u0002\u0010|¨\u0006Ä\u0002"}, d2 = {"Lmz/a;", "Lcom/bytedance/android/live/base/model/user/IUser;", "", "contentAuthorized", "relationAuthorized", "", "setVcdAdversaryAuthorizeState", "isVcdContentAuthorized", "isVcdRelationAuthorized", "isVcdAdversaryContentAuthorized", "isVcdAdversaryRelationAuthorized", "isEnableShowFansClubReverse", "isWithCommercePermission", "Lpy/k;", "getAvatarMedium", "getAvatarLarge", "", "getLocationCity", "isRoomAnchor", "getProperNickName", "getRealNickName", "", "getLiveRoomId", "canJumpToLiveRoom", "", "followStatus", "setFollowStatus", "getRequestId", "requestId", "setRequestId", "getLogPb", "logPb", "setLogPb", "childrenManagerForbidCreateLiveRoom", "childrenManagerForbidWalletFunctions", "", "getBadgeImageList", "isFollowing", "getRemarkNameOrNickname", "getRelationship", "getPayScores", "getNewUserBadges", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "roomAuthStatus", "isFollowingByRoomAuth", "getPrivilegeLevel", "getAvatarThumb", "getUserId", "shouldUseRealName", "setShouldUseRealName", "Lpy/j;", "getFollowInfoExt", "followInfo", "setFollowInfoExt", "Lpy/t;", "getUserAttrExt", "userAttr", "setUserAttrExt", "Lpy/b;", "getAnchorInfoExt", "anchorInfo", "setAnchorInfoExt", "model", "setAvatarThumbImplicit", "setAvatarMediumImplicit", "setAvatarLargeImplicit", "getRemarkNameOrRealNickName", "getBadgeImageListV2Ext", "isSubscriber", "isMysteryMan", "isEnterpriseVerify", "enableShowCommerceSale", "setWithCommercePermission", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "cloneFrom", "type", "setSearchType", "getSearchType", "getBadgeImageListV2", "", "badgeImageList", "setBadgeImageListV2", "Lcom/bytedance/android/live/base/model/user/o0;", "getUserIdCompat", "Lcom/bytedance/android/live/base/model/user/j;", "getCommonVipInfo", "info", "setCommonVipInfo", "getIdStrKt", "getAvatarUrl", LiveSlardarConstants.EXTRA_KEY_URL, "setAvatarUrl", "getUserWatchMonthValid", "enable", "setUserWatchMonthValid", "level", "setCommerceUserLevel", "getCommerceUserLevel", "getEnterprise", "enterPrise", "setEnterprise", "getRoomAutoGiftThanks", "getEncryptedId", "Lpy/o;", "getOwnRoom", "getCastSecUid", "secUid", "setCastSecUid", "Lvh7/e;", "R", "Ljava/lang/Class;", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "value", "linkMicStats", "I", "getLinkMicStats", "()I", "setLinkMicStats", "(I)V", "getIdString", "()Ljava/lang/String;", "setIdString", "(Ljava/lang/String;)V", "idString", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "fanTicketCount", "getEnableShowCommerceSale", "()Z", "setEnableShowCommerceSale", "(Z)V", "getEnableCarManagementPermission", "setEnableCarManagementPermission", "enableCarManagementPermission", "getDisplayId", "setDisplayId", "displayId", "getCity", "setCity", "city", "Lpy/q;", "getPoiInfo", "()Lpy/q;", "setPoiInfo", "(Lpy/q;)V", "poiInfo", "getGender", "setGender", "gender", "getAgeRange", "setAgeRange", "ageRange", "getSignature", "setSignature", "signature", "getLevel", "setLevel", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTopFans", "()Ljava/util/List;", "topFans", "isVerified", "setVerified", "getVerifiedReason", "setVerifiedReason", "verifiedReason", "getUserBadges", "userBadges", "Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "getAnchorLevel", "()Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "setAnchorLevel", "(Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;)V", "anchorLevel", "Lpy/f;", "getBorder", "()Lpy/f;", "border", "getSpecialId", "setSpecialId", "specialId", "getMedal", "()Lpy/k;", "setMedal", "(Lpy/k;)V", "medal", "getBackgroundImgUrl", "setBackgroundImgUrl", "backgroundImgUrl", "getSecret", "setSecret", "secret", "getFollowInfo", "()Lpy/j;", "getUserAttr", "()Lpy/t;", "setUserAttr", "(Lpy/t;)V", "Lcom/bytedance/android/live/base/model/user/l0;", "getDressInfo", "()Lcom/bytedance/android/live/base/model/user/l0;", "setDressInfo", "(Lcom/bytedance/android/live/base/model/user/l0;)V", "dressInfo", "getUnionId", "setUnionId", "unionId", "getAnchorInfo", "()Lpy/b;", "setAnchorInfo", "(Lpy/b;)V", "getShareQrcodeUri", "setShareQrcodeUri", "shareQrcodeUri", "getIncomeSharePercent", "setIncomeSharePercent", "incomeSharePercent", "getExperience", "setExperience", "experience", "getModifyTime", "setModifyTime", "modifyTime", "getStatus", "setStatus", "status", "getTopVipNo", "setTopVipNo", "topVipNo", "getCreateTime", "setCreateTime", "createTime", "getBirthday", "setBirthday", "birthday", "getUserRole", "setUserRole", "userRole", "getSafeNicName", "setSafeNicName", "safeNicName", "getNickName", "setNickName", "nickName", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatarThumbKt", "setAvatarThumbKt", "avatarThumbKt", "Lcom/bytedance/android/live/base/model/user/e;", "getBottomEntry", "()Lcom/bytedance/android/live/base/model/user/e;", "bottomEntry", "getShortId", "setShortId", "shortId", "Lpy/d;", "getUserHonor", "()Lpy/d;", "setUserHonor", "(Lpy/d;)V", "userHonor", "Lcom/bytedance/android/live/base/model/user/t;", "getFansClub", "()Lcom/bytedance/android/live/base/model/user/t;", "setFansClub", "(Lcom/bytedance/android/live/base/model/user/t;)V", "fansClub", "Lpy/c;", "getMAuthenticationInfo", "()Lpy/c;", "setMAuthenticationInfo", "(Lpy/c;)V", "mAuthenticationInfo", "getAdversaryUserStatus", "setAdversaryUserStatus", "adversaryUserStatus", "getPersonalCard", "setPersonalCard", "personalCard", "Lcom/bytedance/android/live/base/model/user/x;", "getIndustryCertification", "()Lcom/bytedance/android/live/base/model/user/x;", "setIndustryCertification", "(Lcom/bytedance/android/live/base/model/user/x;)V", "industryCertification", "getMediaBadgeImageList", "mediaBadgeImageList", "getMysteryMan", "setMysteryMan", "mysteryMan", "isAnonymous", "setAnonymous", "getUserWatchMonth", "setUserWatchMonth", "userWatchMonth", "getPublicScreenOperateFreq", "setPublicScreenOperateFreq", "publicScreenOperateFreq", "getWebcastUid", "setWebcastUid", "webcastUid", "Lcom/bytedance/android/live/base/model/user/g0;", "getSubscribe", "()Lcom/bytedance/android/live/base/model/user/g0;", "setSubscribe", "(Lcom/bytedance/android/live/base/model/user/g0;)V", "subscribe", "Lcom/bytedance/android/live/base/model/user/d0;", "getProfileStyleParams", "()Lcom/bytedance/android/live/base/model/user/d0;", "setProfileStyleParams", "(Lcom/bytedance/android/live/base/model/user/d0;)V", "profileStyleParams", "getTelephone", "setTelephone", "telephone", "<init>", "()V", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public class a implements IUser {
    public static final C0249a Companion = null;
    private static final a mockInst = null;

    @IgnoreProtoFieldCheck
    @SerializedName("link_mic_stats")
    private int linkMicStats;

    /* JADX INFO: renamed from: mz.a$a, reason: collision with other inner class name */
    public static final class C0249a {
        public C0249a() {
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean canJumpToLiveRoom() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public <R extends e<IBaseUser>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean childrenManagerForbidCreateLiveRoom() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean childrenManagerForbidWalletFunctions() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public IBaseUser cloneFrom() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getAdversaryUserStatus() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getAgeRange() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public py.b getAnchorInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.b getAnchorInfoExt() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public IAnchorLevel getAnchorLevel() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public k getAvatarLarge() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public k getAvatarMedium() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public k getAvatarThumb() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public k getAvatarThumbKt() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getAvatarUrl() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getBackgroundImgUrl() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<k> getBadgeImageList() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<k> getBadgeImageListV2() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<k> getBadgeImageListV2Ext() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public long getBirthday() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public f getBorder() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public com.bytedance.android.live.base.model.user.e getBottomEntry() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getCastSecUid() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getCity() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getCommerceUserLevel() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public j getCommonVipInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public long getCreateTime() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getDisplayId() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser, com.bytedance.android.live.base.model.user.l
    public l0 getDressInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getEnableCarManagementPermission() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getEnableShowCommerceSale() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getEncryptedId() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getEnterprise() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getExperience() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getFanTicketCount() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public t getFansClub() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.j getFollowInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.j getFollowInfoExt() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getGender() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getIdStrKt() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser, com.bytedance.android.live.base.model.user.l
    public String getIdString() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getIncomeSharePercent() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public x getIndustryCertification() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getLevel() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getLiveRoomId() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getLocationCity() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getLogPb() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.c getMAuthenticationInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public k getMedal() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<k> getMediaBadgeImageList() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public long getModifyTime() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getMysteryMan() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<k> getNewUserBadges() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getNickName() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getPayScores() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public k getPersonalCard() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public q getPoiInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getPrivilegeLevel() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public d0 getProfileStyleParams() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getProperNickName(boolean r1) {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getPublicScreenOperateFreq() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRealNickName() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRelationship() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRemarkNameOrNickname() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRemarkNameOrRealNickName() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRequestId() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getRoomAutoGiftThanks() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getSafeNicName() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getSearchType() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getSecret() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public String getShareQrcodeUri() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getShortId() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getSignature() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getSpecialId() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getStatus() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public g0 getSubscribe() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getTelephone() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<IBaseUser> getTopFans() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getTopVipNo() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public String getUnionId() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.t getUserAttr() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.t getUserAttrExt() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.t getUserAttrFlex() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<k> getUserBadges() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public d getUserHonor() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getUserId() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getUserRole() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getUserWatchMonth() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getUserWatchMonthValid() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getVerifiedReason() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getWebcastUid() {
        return "";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isAnonymous() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isEnableShowFansClubReverse() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isEnterpriseVerify() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isFollowing() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public boolean isFollowingByRoomAuth(IRoomAuthStatus r1) {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isMysteryMan() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isSubscriber() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdAdversaryContentAuthorized() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdAdversaryRelationAuthorized() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdContentAuthorized() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdRelationAuthorized() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVerified() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isWithCommercePermission() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAdversaryUserStatus(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAgeRange(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setAnchorInfo(py.b r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAnchorInfoExt(py.b r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAnchorLevel(IAnchorLevel r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAnonymous(boolean r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarLargeImplicit(k r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarMediumImplicit(k r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarThumbImplicit(k r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarThumbKt(k r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarUrl(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setBackgroundImgUrl(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setBadgeImageListV2(List<? extends k> r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setBirthday(long r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCastSecUid(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCity(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCommerceUserLevel(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCommonVipInfo(j r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setCreateTime(long r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setDisplayId(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setDressInfo(l0 r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setEnableCarManagementPermission(boolean r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setEnableShowCommerceSale(boolean r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setEnterprise(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setExperience(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFanTicketCount(long r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFansClub(t r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFollowInfoExt(py.j r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFollowStatus(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setGender(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setIdString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setIncomeSharePercent(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setIndustryCertification(x r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setLevel(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setLogPb(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setMAuthenticationInfo(py.c r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setMedal(k r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setModifyTime(long r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setMysteryMan(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setNickName(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setPersonalCard(k r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setPoiInfo(q r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setProfileStyleParams(d0 r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setPublicScreenOperateFreq(long r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setRequestId(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSafeNicName(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSearchType(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSecret(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setShareQrcodeUri(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setShortId(long r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setShouldUseRealName(boolean r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSignature(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSpecialId(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setStatus(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSubscribe(g0 r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setTelephone(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setTopVipNo(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setUnionId(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserAttr(py.t r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserAttrExt(py.t r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserHonor(d r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setUserRole(int r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserWatchMonth(long r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserWatchMonthValid(boolean r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setVcdAdversaryAuthorizeState(boolean r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setVerified(boolean r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setVerifiedReason(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setWebcastUid(String r1) {
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setWithCommercePermission(boolean r1) {
    }

    static {
        Companion = new C0249a();
        mockInst = new a();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public o getOwnRoom() {
        return new User.OwnRoom();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public o0 getUserIdCompat() {
        o0.a.getClass();
        return o0.a.a;
    }

    public static final /* synthetic */ a access$getMockInst$cp() {
        return mockInst;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getLinkMicStats() {
        return this.linkMicStats;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public <R extends e<IBaseUser>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Object r3 = m.b(User.Companion, r2);
        Intrinsics.checkNotNull(r3);
        return (R) r3;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setLinkMicStats(int r1) {
        this.linkMicStats = r1;
    }
}
