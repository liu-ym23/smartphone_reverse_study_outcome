package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a4\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\u0087\b\u001a-\u0010@\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010<\u001a6\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010B\u001a\r\u0010C\u001a\u000200*\u00020\u0002H\u0087\b\u001a\r\u0010D\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001H\u0087\n\u001a&\u0010G\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010J\u001a\u0002HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a4\u0010N\u001a\u0004\u0018\u0001HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a\r\u0010O\u001a\u00020P*\u00020\u0002H\u0087\b\u001a\r\u0010Q\u001a\u00020R*\u00020\u0002H\u0087\b\u001a.\u0010S\u001a\u000200*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\u0087\bø\u0001\u0000\u001a0\u0010V\u001a\u0004\u0018\u00010W*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010Y\u001a&\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010\\\u001a(\u0010]\u001a\u0004\u0018\u00010^*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010_\u001a,\u0010`\u001a\b\u0012\u0004\u0012\u00020b0a*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010c\u001a&\u0010d\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010g\u001a\u00020:*\u00020\u0002H\u0087\b\u001a&\u0010h\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\u0015\u0010i\u001a\u00020:*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\b\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010k\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020m*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u0001H\u0007\u001a.\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a&\u0010o\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010p\u001a\u0002Hq\"\n\b\u0000\u0010q\u0018\u0001*\u00020r*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010s\u001a<\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010W0t*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010u\u001a\r\u0010v\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010x\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010z\u001a\u00020\u0002*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\b\u0010{\u001a\u0004\u0018\u00010W2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010|\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020[H\u0087\b\u001a\u0015\u0010~\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020^H\u0087\b\u001a\u001b\u0010\u007f\u001a\u00020\u0002*\u00020\u00022\f\u0010{\u001a\b\u0012\u0004\u0012\u00020b0aH\u0087\b\u001a\u000f\u0010\u0080\u0001\u001a\u00020\u0002*\u00030\u0081\u0001H\u0087\b\u001aF\u0010\u0082\u0001\u001a\u0003H\u0083\u0001\"\u0005\b\u0000\u0010\u0083\u0001*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001\u0012\u0005\u0012\u0003H\u0083\u00010.H\u0087\bø\u0001\u0000¢\u0006\u0003\u0010\u0086\u0001\u001a3\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,2\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008d\u00010\u001a\"\u00030\u008d\u0001H\u0007¢\u0006\u0003\u0010\u008e\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008f\u0001"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", ActivityLifecycle.NAME, "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "absolute", "absolutePathString", "copyTo", TypedValues.AttributesType.S_TARGET, "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createParentDirectories", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", EventBody.KEY_VALUE, "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public PathsKt__PathUtilsKt() {
    }

    private static final Path Path(String r1) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Path r2 = Paths.get(r1, new String[0]);
        Intrinsics.checkNotNullExpressionValue(r2, "get(...)");
        return r2;
    }

    private static final Path Path(String r2, String... r3) {
        Intrinsics.checkNotNullParameter(r2, "base");
        Intrinsics.checkNotNullParameter(r3, "subpaths");
        Path r4 = Paths.get(r2, (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), String[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r4, "get(...)");
        return r4;
    }

    private static final Path absolute(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Path r4 = r3.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r4, "toAbsolutePath(...)");
        return r4;
    }

    private static final String absolutePathString(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.toAbsolutePath().toString();
    }

    private static final Path copyTo(Path r3, Path r4, boolean r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
        if (r5 == false) goto L5;
        CopyOption[] r8 = {StandardCopyOption.REPLACE_EXISTING};
    L6:
        Path r9 = Files.copy(r6, r7, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), CopyOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "copy(...)");
        return r9;
    L5:
        r8 = new CopyOption[0];
        goto L6
    }

    private static final Path copyTo(Path r2, Path r3, CopyOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, "options");
        Path r7 = Files.copy(r5, r6, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), CopyOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r7, "copy(...)");
        return r7;
    }

    static /* synthetic */ Path copyTo$default(Path r1, Path r2, boolean r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
        if (r3 == false) goto L8;
        CopyOption[] r8 = {StandardCopyOption.REPLACE_EXISTING};
    L9:
        Path r9 = Files.copy(r6, r7, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), CopyOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "copy(...)");
        return r9;
    L8:
        r8 = new CopyOption[0];
        goto L9
    }

    private static final Path createDirectories(Path r2, FileAttribute<?>... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r5 = Files.createDirectories(r4, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "createDirectories(...)");
        return r5;
    }

    private static final Path createDirectory(Path r2, FileAttribute<?>... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r5 = Files.createDirectory(r4, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "createDirectory(...)");
        return r5;
    }

    private static final Path createFile(Path r2, FileAttribute<?>... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r5 = Files.createFile(r4, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "createFile(...)");
        return r5;
    }

    private static final Path createLinkPointingTo(Path r2, Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, TypedValues.AttributesType.S_TARGET);
        Path r6 = Files.createLink(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r6, "createLink(...)");
        return r6;
    }

    public static final Path createParentDirectories(Path r5, FileAttribute<?>... r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r6, "attributes");
        Path r0 = r7.getParent();
        if (r0 != null) goto L5;
    L13:
        return r7;
    L5:
        if (Files.isDirectory(r0, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[0], 0), LinkOption[].class, "com.obric.memorydata.plugin")) == true) goto L13;
        FileAttribute[] r8 = (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r6, r6.length), FileAttribute[].class, "com.obric.memorydata.plugin");     // Catch: FileAlreadyExistsException -> L8
        Intrinsics.checkNotNullExpressionValue(Files.createDirectories(r0, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), FileAttribute[].class, "com.obric.memorydata.plugin")), "createDirectories(...)");     // Catch: FileAlreadyExistsException -> L8
    L8:
        e = move-exception;
        if (Files.isDirectory(r0, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[0], 0), LinkOption[].class, "com.obric.memorydata.plugin")) == true) goto L13;
        throw e;
    }

    private static final Path createSymbolicLinkPointingTo(Path r2, Path r3, FileAttribute<?>... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, "attributes");
        Path r7 = Files.createSymbolicLink(r5, r6, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r7, "createSymbolicLink(...)");
        return r7;
    }

    private static final Path createTempDirectory(String r2, FileAttribute<?>... r3) {
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r4 = Files.createTempDirectory(r2, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r4, "createTempDirectory(...)");
        return r4;
    }

    public static final Path createTempDirectory(Path r3, String r4, FileAttribute<?>... r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "attributes");
        if (r6 == null) goto L5;
        Path r7 = Files.createTempDirectory(r6, r4, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
    L6:
        Intrinsics.checkNotNullExpressionValue(r7, "createTempDirectory(...)");
        return r7;
    L5:
        r7 = Files.createTempDirectory(r4, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        goto L6
    }

    static /* synthetic */ Path createTempDirectory$default(String r0, FileAttribute[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r0 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "attributes");
        Path r4 = Files.createTempDirectory(r0, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r4, "createTempDirectory(...)");
        return r4;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path r1, String r2, FileAttribute[] r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return PathsKt.createTempDirectory(r6, r2, r3);
    }

    private static final Path createTempFile(String r2, String r3, FileAttribute<?>... r4) {
        Intrinsics.checkNotNullParameter(r4, "attributes");
        Path r5 = Files.createTempFile(r2, r3, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "createTempFile(...)");
        return r5;
    }

    public static final Path createTempFile(Path r3, String r4, String r5, FileAttribute<?>... r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "attributes");
        if (r7 == null) goto L5;
        Path r8 = Files.createTempFile(r7, r4, r5, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r6, r6.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
    L6:
        Intrinsics.checkNotNullExpressionValue(r8, "createTempFile(...)");
        return r8;
    L5:
        r8 = Files.createTempFile(r4, r5, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r6, r6.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        goto L6
    }

    static /* synthetic */ Path createTempFile$default(String r1, String r2, FileAttribute[] r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Path r6 = Files.createTempFile(r1, r2, (FileAttribute[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), FileAttribute[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r6, "createTempFile(...)");
        return r6;
    }

    public static /* synthetic */ Path createTempFile$default(Path r1, String r2, String r3, FileAttribute[] r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return PathsKt.createTempFile(r7, r2, r3, r4);
    }

    private static final void deleteExisting(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Files.delete(r3);
    }

    private static final boolean deleteIfExists(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Files.deleteIfExists(r3);
    }

    private static final Path div(Path r2, String r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "other");
        Path r5 = r4.resolve(r3);
        Intrinsics.checkNotNullExpressionValue(r5, "resolve(...)");
        return r5;
    }

    private static final Path div(Path r2, Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "other");
        Path r6 = r4.resolve(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "resolve(...)");
        return r6;
    }

    private static final boolean exists(Path r2, LinkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        return Files.exists(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin"));
    }

    public static final Void fileAttributeViewNotAvailable(Path r3, Class<?> r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r4, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + r4 + " is not available for the file " + r5 + '.');
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path r5, LinkOption... r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r6, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        FileAttributeView r8 = Files.getFileAttributeView(r7, (Class) ZeusTransformUtils.preCheckCast(FileAttributeView.class, Class.class, "com.obric.memorydata.plugin"), (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r6, r6.length), LinkOption[].class, "com.obric.memorydata.plugin"));
        if (r8 != null) goto L5;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        PathsKt.fileAttributeViewNotAvailable(r7, (Class) ZeusTransformUtils.preCheckCast(FileAttributeView.class, Class.class, "com.obric.memorydata.plugin"));
        throw new KotlinNothingValueException();
    L5:
        return (V) ZeusTransformUtils.preCheckCast(r8, FileAttributeView.class, "com.obric.memorydata.plugin");
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path r3, LinkOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r4, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return (V) Files.getFileAttributeView(r5, (Class) ZeusTransformUtils.preCheckCast(FileAttributeView.class, Class.class, "com.obric.memorydata.plugin"), (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), LinkOption[].class, "com.obric.memorydata.plugin"));
    }

    private static final long fileSize(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Files.size(r3);
    }

    private static final FileStore fileStore(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        FileStore r4 = Files.getFileStore(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "getFileStore(...)");
        return r4;
    }

    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> r2) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "builderAction");
        FileVisitorBuilderImpl r0 = new FileVisitorBuilderImpl();
        r3.invoke(r0);
        return r0.build();
    }

    private static final void forEachDirectoryEntry(Path r4, String r5, Function1<? super Path, Unit> r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r5, "glob");
        Intrinsics.checkNotNullParameter(r8, "action");
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newDirectoryStream(r7, r5), Closeable.class, "com.obric.memorydata.plugin");
        DirectoryStream r2 = (DirectoryStream) ZeusTransformUtils.preCheckCast(r9, DirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L15
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L15
    L5:
        if (r1.hasNext() == false) goto L7;
        r8.invoke(r1.next());     // Catch: Throwable -> L15
        goto L5
    L7:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r9, null);
    L13:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        if (r9 == null) goto L13;
        r9.close();
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L23;
        if (r9 != null) goto L27;
    L24:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r9.close();     // Catch: Throwable -> L26
        goto L24
    L23:
        CloseableKt.closeFinally(r9, th);
        goto L24
    }

    static /* synthetic */ void forEachDirectoryEntry$default(Path r3, String r4, Function1 r5, int r6, Object r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L5;
        r4 = "*";
    L5:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r4, "glob");
        Intrinsics.checkNotNullParameter(r9, "action");
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newDirectoryStream(r8, r4), Closeable.class, "com.obric.memorydata.plugin");
        DirectoryStream r1 = (DirectoryStream) ZeusTransformUtils.preCheckCast(r10, DirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L18
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L18
    L8:
        if (r0.hasNext() == false) goto L10;
        r9.invoke(r0.next());     // Catch: Throwable -> L18
        goto L8
    L10:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r10, null);
    L16:
        InlineMarker.finallyEnd(1);
        return;
    L14:
        if (r10 == null) goto L16;
        r10.close();
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L26;
        if (r10 != null) goto L34;
    L27:
        InlineMarker.finallyEnd(1);
        throw th;
    L34:
        r10.close();     // Catch: Throwable -> L29
        goto L27
    L26:
        CloseableKt.closeFinally(r10, th);
        goto L27
    }

    private static final Object getAttribute(Path r2, String r3, LinkOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "attribute");
        Intrinsics.checkNotNullParameter(r4, "options");
        return Files.getAttribute(r5, r3, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), LinkOption[].class, "com.obric.memorydata.plugin"));
    }

    public static final String getExtension(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Path r4 = r3.getFileName();
        if (r4 == null) goto L11;
        String r5 = r4.toString();
        if (r5 == null) goto L12;
        String r6 = StringsKt.substringAfterLast(r5, '.', "");
        if (r6 != null) goto L10;
        return "";
    L10:
        return r6;
    L12:
        return "";
    L11:
        return "";
    }

    public static /* synthetic */ void getExtension$annotations(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
    }

    private static final String getInvariantSeparatorsPath(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return PathsKt.getInvariantSeparatorsPathString(r3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
    }

    public static final String getInvariantSeparatorsPathString(Path r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r7, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r2 = r8.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(r2, "/") == true) goto L6;
        String r1 = r8.toString();
        Intrinsics.checkNotNull(r2);
        return StringsKt.replace$default(r1, r2, "/", false, 4, null);
    L6:
        return r8.toString();
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
    }

    private static final FileTime getLastModifiedTime(Path r2, LinkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        FileTime r5 = Files.getLastModifiedTime(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "getLastModifiedTime(...)");
        return r5;
    }

    public static final String getName(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Path r4 = r3.getFileName();
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        if (r5 != null) goto L9;
        return "";
    L9:
        return r5;
    L5:
        r5 = null;
        goto L6
    }

    public static /* synthetic */ void getName$annotations(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
    }

    public static final String getNameWithoutExtension(Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Path r5 = r4.getFileName();
        if (r5 == null) goto L8;
        String r6 = r5.toString();
        if (r6 == null) goto L8;
        String r7 = StringsKt.substringBeforeLast$default(r6, ".", null, 2, null);
        if (r7 == null) goto L8;
        return r7;
    L8:
        return "";
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
    }

    private static final UserPrincipal getOwner(Path r2, LinkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        return Files.getOwner(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin"));
    }

    private static final String getPathString(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.toString();
    }

    public static /* synthetic */ void getPathString$annotations(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path r2, LinkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        Set<PosixFilePermission> r5 = Files.getPosixFilePermissions(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "getPosixFilePermissions(...)");
        return r5;
    }

    private static final boolean isDirectory(Path r2, LinkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        return Files.isDirectory(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin"));
    }

    private static final boolean isExecutable(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Files.isExecutable(r3);
    }

    private static final boolean isHidden(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Files.isHidden(r3);
    }

    private static final boolean isReadable(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Files.isReadable(r3);
    }

    private static final boolean isRegularFile(Path r2, LinkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        return Files.isRegularFile(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin"));
    }

    private static final boolean isSameFileAs(Path r2, Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "other");
        return Files.isSameFile(r4, r5);
    }

    private static final boolean isSymbolicLink(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Files.isSymbolicLink(r3);
    }

    private static final boolean isWritable(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Files.isWritable(r3);
    }

    public static final List<Path> listDirectoryEntries(Path r2, String r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "glob");
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newDirectoryStream(r4, r3), Closeable.class, "com.obric.memorydata.plugin");
        DirectoryStream r6 = (DirectoryStream) ZeusTransformUtils.preCheckCast(r5, DirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L6
        List<Path> r7 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r5, null);
        return r7;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path r1, String r2, int r3, Object r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = "*";
    L6:
        return PathsKt.listDirectoryEntries(r5, r2);
    }

    private static final Path moveTo(Path r3, Path r4, boolean r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
        if (r5 == false) goto L5;
        CopyOption[] r8 = {StandardCopyOption.REPLACE_EXISTING};
    L6:
        Path r9 = Files.move(r6, r7, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), CopyOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "move(...)");
        return r9;
    L5:
        r8 = new CopyOption[0];
        goto L6
    }

    private static final Path moveTo(Path r2, Path r3, CopyOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, "options");
        Path r7 = Files.move(r5, r6, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), CopyOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r7, "move(...)");
        return r7;
    }

    static /* synthetic */ Path moveTo$default(Path r1, Path r2, boolean r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
        if (r3 == false) goto L8;
        CopyOption[] r8 = {StandardCopyOption.REPLACE_EXISTING};
    L9:
        Path r9 = Files.move(r6, r7, (CopyOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), CopyOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "move(...)");
        return r9;
    L8:
        r8 = new CopyOption[0];
        goto L9
    }

    private static final boolean notExists(Path r2, LinkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        return Files.notExists(r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin"));
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path r3, LinkOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r4, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        BasicFileAttributes r6 = Files.readAttributes(r5, (Class) ZeusTransformUtils.preCheckCast(BasicFileAttributes.class, Class.class, "com.obric.memorydata.plugin"), (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), LinkOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r6, "readAttributes(...)");
        return (A) ZeusTransformUtils.preCheckCast(r6, BasicFileAttributes.class, "com.obric.memorydata.plugin");
    }

    private static final Map<String, Object> readAttributes(Path r2, String r3, LinkOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        Intrinsics.checkNotNullParameter(r4, "options");
        Map<String, Object> r6 = Files.readAttributes(r5, r3, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), LinkOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r6, "readAttributes(...)");
        return r6;
    }

    private static final Path readSymbolicLink(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Path r4 = Files.readSymbolicLink(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "readSymbolicLink(...)");
        return r4;
    }

    public static final Path relativeTo(Path r5, Path r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r6, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r7, r8);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + r7 + "\nbase path: " + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final Path relativeToOrNull(Path r2, Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r4, r5);
    L5:
        return null;
    }

    public static final Path relativeToOrSelf(Path r2, Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "base");
        Path r6 = PathsKt.relativeToOrNull(r4, r5);
        if (r6 != null) goto L6;
        return r4;
    L6:
        return r6;
    }

    private static final Path setAttribute(Path r2, String r3, Object r4, LinkOption... r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r3, "attribute");
        Intrinsics.checkNotNullParameter(r5, "options");
        Path r7 = Files.setAttribute(r6, r3, r4, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), LinkOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r7, "setAttribute(...)");
        return r7;
    }

    private static final Path setLastModifiedTime(Path r2, FileTime r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        Path r5 = Files.setLastModifiedTime(r4, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "setLastModifiedTime(...)");
        return r5;
    }

    private static final Path setOwner(Path r2, UserPrincipal r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        UserPrincipal r5 = (UserPrincipal) ZeusTransformUtils.wrapperContextForParams(r3, UserPrincipal.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        Path r6 = Files.setOwner(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r6, "setOwner(...)");
        return r6;
    }

    private static final Path setPosixFilePermissions(Path r2, Set<? extends PosixFilePermission> r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        Path r6 = Files.setPosixFilePermissions(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r6, "setPosixFilePermissions(...)");
        return r6;
    }

    private static final Path toPath(URI r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Path r2 = Paths.get(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "get(...)");
        return r2;
    }

    private static final <T> T useDirectoryEntries(Path r4, String r5, Function1<? super Sequence<? extends Path>, ? extends T> r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r5, "glob");
        Intrinsics.checkNotNullParameter(r8, "block");
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newDirectoryStream(r7, r5), Closeable.class, "com.obric.memorydata.plugin");
        DirectoryStream r2 = (DirectoryStream) ZeusTransformUtils.preCheckCast(r9, DirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L11
        T r10 = (T) r8.invoke(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")));
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r9, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r10;
    L7:
        if (r9 == null) goto L9;
        r9.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r9 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r9.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r9, th);
        goto L20
    }

    static /* synthetic */ Object useDirectoryEntries$default(Path r3, String r4, Function1 r5, int r6, Object r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L5;
        r4 = "*";
    L5:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r4, "glob");
        Intrinsics.checkNotNullParameter(r9, "block");
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newDirectoryStream(r8, r4), Closeable.class, "com.obric.memorydata.plugin");
        DirectoryStream r1 = (DirectoryStream) ZeusTransformUtils.preCheckCast(r10, DirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L14
        Object r11 = r9.invoke(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r10, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r11;
    L10:
        if (r10 == null) goto L12;
        r10.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r10 != null) goto L30;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L30:
        r10.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r10, th);
        goto L23
    }

    public static final void visitFileTree(Path r2, int r3, boolean r4, Function1<? super FileVisitorBuilder, Unit> r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "builderAction");
        PathsKt.visitFileTree(r6, PathsKt.fileVisitor(r7), r3, r4);
    }

    public static final void visitFileTree(Path r2, FileVisitor<Path> r3, int r4, boolean r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        FileVisitor r7 = (FileVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FileVisitor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "visitor");
        if (r5 == false) goto L5;
        Set r8 = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    L6:
        Files.walkFileTree(r6, r8, r4, r7);
        return;
    L5:
        r8 = SetsKt.emptySet();
        goto L6
    }

    public static /* synthetic */ void visitFileTree$default(Path r1, int r2, boolean r3, Function1 r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = Integer.MAX_VALUE;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = false;
    L8:
        PathsKt.visitFileTree(r7, r2, r3, r8);
    }

    public static /* synthetic */ void visitFileTree$default(Path r1, FileVisitor r2, int r3, boolean r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        FileVisitor r8 = (FileVisitor) ZeusTransformUtils.wrapperContextForParams(r2, FileVisitor.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = Integer.MAX_VALUE;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        PathsKt.visitFileTree(r7, r8, r3, r4);
    }

    public static final Sequence<Path> walk(Path r2, PathWalkOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        return (Sequence) ZeusTransformUtils.preCheckCast(new PathTreeWalk(r4, r3), Sequence.class, "com.obric.memorydata.plugin");
    }
}
